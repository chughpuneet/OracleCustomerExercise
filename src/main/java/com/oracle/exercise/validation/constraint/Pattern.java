package com.oracle.exercise.validation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/**
 * Constraint annotation for the pattern to match the field value
 */
public @interface Pattern {
    public String value();
    public String defaultFailMessage = "Pattern validation failed";
}
