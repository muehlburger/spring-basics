package org.springframework.basics.section01

import org.springframework.context.support.StaticApplicationContext
import spock.lang.Specification

class SimpleApplicationContextTest extends Specification {

    def "test a simple application context"() {
        expect:
            def context = new StaticApplicationContext()
            context.registerSingleton("serviceA" , ServiceA.class)
            context.getBean(ServiceA) != null
            context.getBean("serviceA") != null
    }

    public static class ServiceA{}

}
