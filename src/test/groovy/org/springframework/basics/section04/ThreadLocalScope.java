package org.springframework.basics.section04;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalScope implements Scope {

    private ThreadLocal<Map<String, Object>> scope = new NamedThreadLocal<Map<String,Object>>("thread-scope") {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> map = scope.get();
        if (!map.containsKey(name)) {
            map.put(name, objectFactory.getObject());
        }
        return map.get(name);
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> map = scope.get();
        return map.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // do nothing
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "thread";
    }
}
