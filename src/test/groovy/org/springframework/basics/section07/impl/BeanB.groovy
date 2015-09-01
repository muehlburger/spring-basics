package org.springframework.basics.section07.impl

import org.springframework.basics.section07.interfaces.SomeInterface

class BeanB implements SomeInterface {

    @Override
    public String getStuff() {
        return "BeanB"
    }
}
