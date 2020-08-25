package com.tomash.gombosh.api.rest;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface Retry {
    /**
     * The max retry attempt (default is 3).
     */
    int max() default 3;
}
