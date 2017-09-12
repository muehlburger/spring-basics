package org.springframework.basics.section05.impl


import org.springframework.beans.factory.InitializingBean

import javax.annotation.PostConstruct

class InitBean implements InitializingBean {

    String afterPropertiesSet
    String postConstructed

    void afterPropertiesSet() throws Exception {
        println "afterPropertiesSet called"
        afterPropertiesSet = "value"
    }

    @PostConstruct
    void setPostConstructed() {
        println "PostConstruct called"
        this.postConstructed = "value"
    }



}
