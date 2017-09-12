package org.springframework.basics.section08.impl

import org.springframework.basics.section08.interfaces.SomeInterface
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
@Qualifier("first")
class BeanA implements SomeInterface {

    @Override
    public String getStuff() {
        return "BeanA"
    }
}
