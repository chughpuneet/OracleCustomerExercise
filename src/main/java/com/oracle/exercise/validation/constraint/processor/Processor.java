package com.oracle.exercise.validation.constraint.processor;

import com.oracle.exercise.validation.exception.ValidationException;

import java.lang.annotation.Annotation;

/**
 * Processor interface, all processor implementations must implement it
 */
public interface Processor {
    /**
     * Method to process the constraint
     *
     * @param val, value of the field
     * @param fieldName, name of the field
     * @param annotation, annotation defined on the field
     *
     * @return the validation result
     *
     * @throws ValidationException if the validation is failed
     */
    public boolean processConstraint(Object val, String fieldName, Annotation annotation) throws ValidationException;
}
