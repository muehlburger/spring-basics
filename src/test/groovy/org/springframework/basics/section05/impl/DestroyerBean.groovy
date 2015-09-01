package org.springframework.basics.section05.impl


import org.springframework.beans.factory.DisposableBean

import javax.annotation.PreDestroy

class DestroyerBean implements DisposableBean {

    String destroyed
    String preDestroyed

    @Override
    void destroy() throws Exception {
        println "destroy called"
        destroyed = "destroyed"
    }

    @PreDestroy
    void setPreDestroyed() {
        println "PreDestroy called"
        this.preDestroyed = "preDestroyed"
    }
}
