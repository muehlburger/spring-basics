package org.springframework.basics.section03

import org.springframework.basics.section03.impl.PrototypeImpl
import org.springframework.basics.section03.impl.SingletonImpl
import org.springframework.basics.section03.interfaces.PrototypeClass
import org.springframework.basics.section03.interfaces.SingletonClass
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes=TestConfiguration)
class ScopeTest extends Specification  {

    @Autowired
    private SingletonClass singleton

    def "scope test"() {
        expect:
           singleton.getStuffFromPrototype() != singleton.getStuffFromPrototype()
    }

    // TODO mark class as configuration class
    public static class TestConfiguration {

        // TODO "register" bean into Context
        public SingletonClass singletonBean() {
            return new SingletonImpl()
        }

        // TODO "register" bean into Context
        // TODO set the correct scope
        public PrototypeClass prototypeBean() {
            return new PrototypeImpl()
        }
    }
}
