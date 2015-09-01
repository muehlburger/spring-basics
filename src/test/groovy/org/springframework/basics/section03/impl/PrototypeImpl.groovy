package org.springframework.basics.section03.impl

import org.springframework.basics.section03.interfaces.PrototypeClass

class PrototypeImpl implements PrototypeClass {

    String state = UUID.randomUUID().toString()

    @Override
    public String getState() {
        return state
    }

}
