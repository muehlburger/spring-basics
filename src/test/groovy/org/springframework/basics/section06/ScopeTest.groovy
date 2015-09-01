package org.springframework.basics.section06

import org.springframework.basics.section06.impl.PrototypeImpl
import org.springframework.basics.section06.impl.SingletonImpl
import org.springframework.basics.section06.interfaces.PrototypeClass
import org.springframework.basics.section06.interfaces.SingletonClass
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.ApplicationContext
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

    def "profile test"() {
        expect:
           singleton.getStuffFromPrototype() != singleton.getStuffFromPrototype()
    }

    @Configuration
    public static class TestConfiguration {

        @Bean
        @Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
        public SingletonClass singletonBean() {
            return new SingletonImpl()
        }

        @Bean
        @Scope(proxyMode = ScopedProxyMode.INTERFACES, scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        //@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        public PrototypeClass prototypeBean() {
            return new PrototypeImpl()
        }
    }
}
