package org.springframework.facet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.facet.impl.ComponentImpl;
import org.springframework.facet.interfaces.IComponent;

@Configuration
@ComponentScan("org.springframework.facet")
public class MainConfig {

    @Bean
    public IComponent component() {
        return  new ComponentImpl();
    }

}
