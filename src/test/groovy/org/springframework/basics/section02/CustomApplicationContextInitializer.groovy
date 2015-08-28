package org.springframework.basics.section02

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.core.env.Environment

/**
 * Custom {@link ApplicationContextInitializer} implementation.
 */
class CustomApplicationContextInitializer implements ApplicationContextInitializer<GenericApplicationContext> {

    @Override
    void initialize(GenericApplicationContext applicationContext) {
        Environment environment = applicationContext.getEnvironment();
        environment.setActiveProfiles("profileA", "profileB")

        // environment.propertySources.addLast(...)
        // this block is executed before!!! applicationContext.refresh()
    }

}
