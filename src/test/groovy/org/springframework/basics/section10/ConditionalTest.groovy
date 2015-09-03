package org.springframework.basics.section10

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = TestConfiguration)
class ConditionalTest extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    def "@Conditional showcase"() {
        expect:
            def text = applicationContext.getBean("text")
            text == "B"
    }

    @Configuration
    @Import(TestConfigurationB)
    private static class TestConfiguration {

        @Bean(name = "text")
        // TODO set condition to not register bean
        public String textA() {
            return "A"
        }

    }

    @Configuration
    private static class TestConfigurationB {

        @Bean(name = "text")
        // TODO set condition to register bean
        public String textB() {
            return "B"
        }

    }

    // TODO implement Condition
    private static class TrueCondition {

    }

    // TODO implement Condition
    private static class FalseCondition {

    }

}
