package org.springframework.basics.section06

import org.mockito.Mockito
import org.mockito.internal.util.MockUtil
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

        // TODO register Repository into context

    }

    // TODO implement a BeanPostProcessor
    // HINT use Mockito to mock a bean
    public static class Processor {

    }

    private static boolean isRepositoryBean(bean) {
        return bean instanceof IRepository;
    }
}
