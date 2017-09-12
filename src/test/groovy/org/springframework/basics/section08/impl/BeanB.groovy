package org.springframework.basics.section08.impl

import org.springframework.basics.section08.interfaces.SomeInterface
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("second")
class BeanB implements SomeInterface {

    @Override
    public String getStuff() {
        return "BeanB"
    }
}
