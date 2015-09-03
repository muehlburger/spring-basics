package org.springframework.basics.section05.impl


import org.springframework.beans.factory.InitializingBean

import javax.annotation.PostConstruct

// TODO implement an initializing bean
class InitBean {

    String afterPropertiesSet
    String postConstructed

    void afterPropertiesSet() throws Exception {
        println "afterPropertiesSet called"
        afterPropertiesSet = "value"
    }

    // TODO register hook for PostConstruction
    void setPostConstructed() {
        println "PostConstruct called"
        this.postConstructed = "postConstructed"
    }



}
