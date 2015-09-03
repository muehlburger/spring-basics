package org.springframework.basics.section05

import org.springframework.basics.section05.impl.DestroyerBean
import org.springframework.basics.section05.impl.InitBean

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.StaticApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class BeanLifecycleTest extends Specification {

    def "bean lifecycle test"() {
        expect:

            def context = new StaticApplicationContext()
            someSpringStuff(context)

            def initBean = context.getBean(InitBean.class)
            def disposableBean = context.getBean(DestroyerBean.class)

            initBean.postConstructed != null
            initBean.afterPropertiesSet != null

            context.close()

            disposableBean.preDestroyed != null
            disposableBean.destroyed != null
    }

    private static void someSpringStuff(StaticApplicationContext context) {
        def bpp = new InitDestroyAnnotationBeanPostProcessor()
        bpp.setInitAnnotationType(PostConstruct)
        bpp.setDestroyAnnotationType(PreDestroy)

        context.beanFactory.registerSingleton("BPP", bpp)
        context.registerSingleton("initBean", InitBean.class)
        context.registerSingleton("destroyerBean", DestroyerBean.class)

        context.refresh()
    }


}
