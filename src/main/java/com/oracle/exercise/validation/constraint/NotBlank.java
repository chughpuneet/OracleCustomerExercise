package com.oracle.exercise.validation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/**
 * Constraint annotation for Not blank field value
 */
public @interface NotBlank {
    public String defaultFailMessage = "Not blank validation failed";
}
