package org.springframework.basics.section07

import org.springframework.basics.section07.interfaces.IComponent
import org.springframework.basics.section07.interfaces.IFactory
import org.springframework.basics.section07.interfaces.IRepository
import org.springframework.basics.section07.interfaces.IService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = TestConfiguration)
class ClassPathScanTest extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    def "@ComponentScan test"() {
        expect:
            applicationContext.getBean(IService) != null
            applicationContext.getBean(IComponent) != null
            applicationContext.getBean(IFactory) != null
            applicationContext.getBean(IRepository) != null
    }

    @Configuration
    @ComponentScan("org.springframework.basics.section08")
    public static class TestConfiguration {

    }

}
