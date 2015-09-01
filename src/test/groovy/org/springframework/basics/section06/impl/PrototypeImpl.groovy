package org.springframework.basics.section06.impl

import org.springframework.basics.section06.interfaces.PrototypeClass

class PrototypeImpl implements PrototypeClass {

    String state = UUID.randomUUID().toString()

    @Override
    public String getState() {
        return state
    }

}
