package com.oracle.exercise.validation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/**
 * Constraint annotation for the minimum integer field value
 */
public @interface Min {

    public int value();
    public String defaultFailMessage = "Minimum value validation failed";
}
