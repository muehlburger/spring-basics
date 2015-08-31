package org.springframework.basics.sectionxy

import org.springframework.test.context.TestContext
import org.springframework.test.context.TestExecutionListener

/**
 * Custom {@link TestExecutionListener} implementation.
 */
class CustomTestExecutionListener implements TestExecutionListener {

    /**
     * {@inheritDoc}
     */
    @Override
    void beforeTestClass(TestContext testContext) throws Exception {
        println "before test class"
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void prepareTestInstance(TestContext testContext) throws Exception {
        println "prepare test instance"
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void beforeTestMethod(TestContext testContext) throws Exception {
        println "before test method"
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void afterTestMethod(TestContext testContext) throws Exception {
        println "after test method"
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void afterTestClass(TestContext testContext) throws Exception {
        println "after test class"
    }

}
