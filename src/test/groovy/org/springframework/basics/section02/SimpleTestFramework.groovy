package org.springframework.basics.section02

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.ContextHierarchy
import org.springframework.test.context.TestExecutionListeners
import spock.lang.Specification

import static org.springframework.test.context.TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS

@ContextConfiguration(classes = TestConfiguration)
class SimpleTestFramework extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    def "application context must not be null"() {
        expect:
            applicationContext != null
    }

    @Configuration
    public static class TestConfiguration {
    }

}
