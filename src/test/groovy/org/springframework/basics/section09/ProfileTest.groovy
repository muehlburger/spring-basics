package org.springframework.basics.section09

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes=TestConfiguration)
// TODO activate correct profile
class ProfileTest extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    def "profile test"() {
        expect:
            def text = applicationContext.getBean("text")
            text == "B"
    }

    @Configuration
    @Import(TestConfigurationB)
    public static class TestConfiguration {

//        @Profile("default")
        @Bean(name = "text")
        public String textA() {
            return "A"
        }

    }

    @Configuration
    public static class TestConfigurationB {

        // TODO set correct profile
        @Bean(name = "text")
        public String textB() {
            return "B"
        }

    }

}
