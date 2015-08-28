package org.springframework.basics.sectionxx

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import spock.lang.Specification

class CustomProtocolHandlerTest extends Specification {

    def "the custom protocol handler should hook into the spring application lifecycle"() {
        expect:
            def context = new AnnotationConfigApplicationContext(TestConfiguration)
            context.stop()
    }

    @Configuration
    public static class TestConfiguration {
        @Bean
        public CustomProtocolHandler customProtocolHandler() {
            return new CustomProtocolHandler()
        }
    }

}
