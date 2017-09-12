package org.springframework.basics.section03

import org.springframework.basics.section03.impl.PrototypeImpl
import org.springframework.basics.section03.impl.SingletonImpl
import org.springframework.basics.section03.interfaces.PrototypeClass
import org.springframework.basics.section03.interfaces.SingletonClass
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Configurable
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

    @Configuration
    public static class TestConfiguration {

        @Bean
        public SingletonClass singletonBean() {
            return new SingletonImpl()
        }

        @Bean
        @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
        public PrototypeClass prototypeBean() {
            return new PrototypeImpl()
        }
    }
}
