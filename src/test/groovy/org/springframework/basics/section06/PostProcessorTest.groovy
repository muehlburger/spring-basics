package org.springframework.basics.section06

import org.mockito.Mockito
import org.mockito.internal.util.MockUtil
import org.springframework.basics.section06.impl.RepositoryImpl
import org.springframework.basics.section06.interfaces.IRepository
import org.springframework.beans.BeansException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.stereotype.Repository
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = TestConfiguration)
class PostProcessorTest extends Specification {

    @Autowired
    private IRepository repository

    def "@ComponentScan test"() {
        expect:
            new MockUtil().isMock(repository)
    }

    @Configuration
    public static class TestConfiguration {

        @Bean
        public Processor processor() {
            new Processor();
        }

        @Bean
        public RepositoryImpl repository() {
            return new RepositoryImpl();
        }

    }

    public static class Processor implements BeanPostProcessor {

        @Override
        Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            return Mockito.mock(IRepository);
        }

        @Override
        Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            return bean;
        }
    }

    private static boolean isRepositoryBean(bean) {
        return bean instanceof IRepository;
    }
}
