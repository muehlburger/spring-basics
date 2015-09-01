package org.springframework.basics.section08

import org.springframework.basics.section08.impl.DestroyerBean
import org.springframework.basics.section08.impl.InitBean

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes=TestConfiguration)
class BeanLifecycleTest extends Specification  {

    @Autowired
    private InitBean initBean

    @Autowired
    private DestroyerBean destroyerBean

    def "bean lifecycle test"() {
        expect:
            initBean.postConstructed != null
            initBean.afterPropertiesSet != null

//            destroyerBean.preDestroyed != null
//            destroyerBean.destroyed != null
    }

    @Configuration
    public static class TestConfiguration {

        @Bean
        public InitBean initBean() {
            return new InitBean()
        }

        @Bean
        public DestroyerBean destroyerBean() {
            return new DestroyerBean()
        }


    }
}
