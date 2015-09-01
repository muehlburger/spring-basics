package org.springframework.basics.section07.interfaces;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
@Documented
public @interface Factory {

    String value() default "";

}
