package org.springframework.basics.section04;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

// TODO implement Scope
public class ThreadLocalScope  {

    // TODO use variable to register beans into the Scope
    private ThreadLocal<Map<String, Object>> scope = new NamedThreadLocal<Map<String,Object>>("thread-scope") {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

}
