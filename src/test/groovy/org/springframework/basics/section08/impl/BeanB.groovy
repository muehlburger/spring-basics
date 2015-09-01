package org.springframework.basics.section08.impl

import org.springframework.basics.section08.interfaces.SomeInterface

class BeanB implements SomeInterface {

    @Override
    public String getStuff() {
        return "BeanB"
    }
}
