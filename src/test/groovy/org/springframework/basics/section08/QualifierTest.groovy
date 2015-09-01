package org.springframework.basics.section08

import org.springframework.basics.section08.impl.BeanA
import org.springframework.basics.section08.impl.BeanB
import org.springframework.basics.section08.interfaces.SomeInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes=TestConfiguration)
class QualifierTest extends Specification  {

    @Autowired
    @Qualifier("beanA")
    private SomeInterface someBean

    @Autowired
    private SomeInterface beanB

    def "qualifier test"() {
        expect:
            someBean.stuff != null
            someBean.stuff == "BeanA"

            beanB.stuff != null
            beanB.stuff == "BeanB"
    }

    @Configuration
    public static class TestConfiguration {

        @Bean
        public SomeInterface beanA() {
            return new BeanA()
        }

        @Bean
        public SomeInterface beanB() {
            return new BeanB()
        }


    }
}
