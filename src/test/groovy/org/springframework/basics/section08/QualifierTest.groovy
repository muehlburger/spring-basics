package org.springframework.basics.section08

import org.springframework.basics.section08.impl.BeanA
import org.springframework.basics.section08.impl.BeanB
import org.springframework.basics.section08.interfaces.SomeInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes=TestConfiguration)
class QualifierTest extends Specification  {

    @Autowired
    @Qualifier("first")
    private SomeInterface someBean

    // TODO autowire the correct bean
    @Autowired
    @Qualifier("second")
    private SomeInterface someOtherBean

    def "qualifier test"() {
        expect:
            someBean.stuff != null
            someBean.stuff == "BeanA"
            someBean instanceof BeanA

            someOtherBean.stuff != null
            someOtherBean.stuff == "BeanB"
            someOtherBean instanceof BeanB
    }

    @Configuration
    @ComponentScan
    public static class TestConfiguration {

    }
}
