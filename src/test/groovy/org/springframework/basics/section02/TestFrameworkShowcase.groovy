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

@ContextConfiguration(classes = TestConfiguration, initializers = CustomApplicationContextInitializer)
//@TestExecutionListeners(value = [DependencyInjectionTestExecutionListener,
//        TransactionalTestExecutionListener,
//        DirtiesContextTestExecutionListener],
//        mergeMode = REPLACE_DEFAULTS)
@TestExecutionListeners(value = [CustomTestExecutionListener], mergeMode = MERGE_WITH_DEFAULTS)
//@ContextHierarchy([
//        @ContextConfiguration(locations = "classpath:context1.xml"),
//        @ContextConfiguration(locations = "classpath:context2.xml")
//])
//@ActiveProfiles("profileA")
class TestFrameworkShowcase extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    // @DirtiesContext
    // @Transactional
    def "application context must not be null"() {
        expect:
            applicationContext != null
    }

    @Configuration
    public static class TestConfiguration {
        // create a default context
    }

}
