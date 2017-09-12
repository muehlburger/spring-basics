package org.springframework.basics.section04;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

// TODO implement Scope
public class ThreadLocalScope implements Scope {

    // TODO use variable to register beans into the Scope
    private ThreadLocal<Map<String, Object>> scope = new NamedThreadLocal<Map<String,Object>>("thread-scope") {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(!scope.get().containsKey(name)) {
            scope.get().put(name, objectFactory.getObject());

        }
        return scope.get().get(name);
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }


}
