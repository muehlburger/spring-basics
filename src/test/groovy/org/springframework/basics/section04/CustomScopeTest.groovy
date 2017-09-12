package org.springframework.basics.section04

import org.springframework.basics.section08.impl.BeanA
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.CustomScopeConfigurer
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = TestConfiguration)
class CustomScopeTest extends Specification {

    @Autowired
    private ApplicationContext context

    def "thread scope registration"() {
        expect:
            def thread1Bean1 = null
            def thread1Bean2 = null
            def thread2Bean1 = null
            def thread2Bean2 = null

            def thread1 = Thread.start {
                thread1Bean1 = context.getBean(BeanA.class)
                thread1Bean2 = context.getBean(BeanA.class)
                println "${Thread.currentThread().id} $thread1Bean1"
                println "${Thread.currentThread().id} $thread1Bean2"
            }
            def thread2 = Thread.start {
                thread2Bean1 = context.getBean(BeanA.class)
                thread2Bean2 = context.getBean(BeanA.class)
                println "${Thread.currentThread().id} $thread2Bean1"
                println "${Thread.currentThread().id} $thread2Bean2"
            }

            thread1.join()
            thread2.join()

            thread1Bean1 == thread1Bean2
            thread2Bean1 == thread2Bean2

            thread1Bean1 != thread2Bean1
            thread1Bean2 != thread2Bean2
    }

    @Configuration
    public static class TestConfiguration {

        @Bean
        public static CustomScopeConfigurer customScopeConfigurer() {
            CustomScopeConfigurer configurer = new CustomScopeConfigurer();
            configurer.setScopes(["thread":new ThreadLocalScope()])

            return configurer
        }

        @Bean
        @Scope(scopeName = "thread")
        public BeanA dateFormat() {
            return new BeanA()
        }

    }

}
