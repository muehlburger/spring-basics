package org.springframework.basics.section09

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes=TestConfiguration)
@ActiveProfiles("profileA")
class ProfileTest extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    def "profile test"() {
        expect:
            def text = applicationContext.getBean("text")
            println text
    }

    @Configuration
    public static class TestConfiguration {

        @Profile("profileA")
        @Bean(name = "text")
        public String textA() {
            return "A"
        }

        @Profile("profileB")
        @Bean(name = "text")
        public String textB() {
            return "B"
        }

    }

}
