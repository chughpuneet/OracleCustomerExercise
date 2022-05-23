package com.oracle.exercise.validation.constraint.processor;

import com.oracle.exercise.validation.exception.ValidationException;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Constraint processor to process the Not Null field value
 */
public class NotNullProcessor implements Processor {
    @Override
    public boolean processConstraint(Object val, String fieldName,  Annotation annotation) throws ValidationException {
        if(val != null){
            return true;
        }
        throw new ValidationException(fieldName + " cannot be Null", fieldName);
    }

}
