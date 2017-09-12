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
        @Conditional(FalseCondition)
        public String textA() {
            return "A"
        }

    }

    @Configuration
    private static class TestConfigurationB {

        @Bean(name = "text")
        @Conditional(TrueCondition)
        public String textB() {
            return "B"
        }

    }

    private static class TrueCondition implements Condition{

        @Override
        boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true
        }
    }

    private static class FalseCondition implements Condition {
        @Override
        boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false
        }
    }

}
