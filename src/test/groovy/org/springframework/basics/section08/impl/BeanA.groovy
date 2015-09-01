package org.springframework.basics.section08.impl

import org.springframework.basics.section08.interfaces.SomeInterface

class BeanA implements SomeInterface {

    @Override
    public String getStuff() {
        return "BeanA"
    }
}
