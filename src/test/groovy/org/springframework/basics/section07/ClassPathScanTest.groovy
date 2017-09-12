package org.springframework.basics.section07

import org.springframework.basics.section07.interfaces.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = TestConfiguration)
class ClassPathScanTest extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    def "@ComponentScan test"() {
        expect:
            def service = applicationContext.getBean(IService)
            service != null
            AnnotationUtils.findAnnotation(service.class, Service.class) != null

            def component = applicationContext.getBean(IComponent)
            component != null
            AnnotationUtils.findAnnotation(component.class, Component.class) != null

            def factory = applicationContext.getBean(IFactory)
            factory != null
            AnnotationUtils.findAnnotation(factory.class, Factory.class) != null

            def repository = applicationContext.getBean(IRepository)
            repository != null
            AnnotationUtils.findAnnotation(repository.class, Repository.class) != null
    }

    @Configuration
    @ComponentScan("org.springframework.basics.section07")
    public static class TestConfiguration {

    }

}
