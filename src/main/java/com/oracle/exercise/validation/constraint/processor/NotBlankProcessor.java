package com.oracle.exercise.validation.constraint.processor;

import com.oracle.exercise.validation.exception.ValidationException;

import java.lang.annotation.Annotation;

/**
 * Constraint processor to process the validation of not blank string
 */
public class NotBlankProcessor implements Processor {
    @Override
    public boolean processConstraint(Object val, String fieldName,  Annotation annotation) throws ValidationException {
        if(null == val || val.toString().trim().equals("")){
            throw new ValidationException(fieldName + " cannot be blank", fieldName);
        }
        return true;
    }
}
