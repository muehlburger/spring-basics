package org.springframework.basics.section05.impl


import org.springframework.beans.factory.DisposableBean

import javax.annotation.PreDestroy


// TODO implement a disposable bean
class DestroyerBean {

    String destroyed
    String preDestroyed

    void destroy() throws Exception {
        println "destroy called"
        destroyed = "destroyed"
    }

    // TODO register hook for pre destruction
    void setPreDestroyed() {
        println "PreDestroy called"
        this.preDestroyed = "preDestroyed"
    }
}
