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

    def "thead scope registration"() {
        expect:
            def thread1 = Thread.start {
                println "${Thread.currentThread().id} ${context.getBean(BeanA.class)}"
                println "${Thread.currentThread().id} ${context.getBean(BeanA.class)}"
            }
            def thread2 = Thread.start {
                println "${Thread.currentThread().id} ${context.getBean(BeanA.class)}"
                println "${Thread.currentThread().id} ${context.getBean(BeanA.class)}"
            }

            thread1.join()
            thread2.join()
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
        @Scope("thread")
        public BeanA dateFormat() {
            return new BeanA()
        }

    }

}
