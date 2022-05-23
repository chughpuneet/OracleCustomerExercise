package com.oracle.exercise.validation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/**
 * Constraint annotation for the not null field value
 */
public @interface NotNull {
    public String defaultFailMessage = "Not null validation failed";
}
