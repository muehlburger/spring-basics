package org.springframework.basics.section03

import org.springframework.context.support.StaticApplicationContext
import spock.lang.Specification

class ParentApplicationContextTest extends Specification {

    def "test parent application context"() {
        expect:
            def parent = new StaticApplicationContext()
            parent.registerSingleton("serviceA", ServiceA)

            def child = new StaticApplicationContext(parent)
            child.registerSingleton("serviceB", ServiceB)

            child.getBean(ServiceA) != null
            child.getBean(ServiceB) != null

            parent.getBean(ServiceA) != null
            parent.getBeansOfType(ServiceB).isEmpty()
    }

    public static class ServiceA{}
    public static class ServiceB{}

}
