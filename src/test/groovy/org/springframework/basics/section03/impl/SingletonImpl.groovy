package org.springframework.basics.section03.impl

import org.springframework.basics.section03.interfaces.PrototypeClass
import org.springframework.basics.section03.interfaces.SingletonClass
import org.springframework.beans.factory.annotation.Autowired

class SingletonImpl implements SingletonClass {

    @Autowired
    private PrototypeClass prototype;

    @Override
    public String getStuffFromPrototype() {
        prototype.state
    }


}
