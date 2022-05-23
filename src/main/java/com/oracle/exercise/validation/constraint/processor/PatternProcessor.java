package com.oracle.exercise.validation.constraint.processor;

import com.oracle.exercise.validation.constraint.Pattern;
import com.oracle.exercise.validation.exception.ValidationException;

import java.lang.annotation.Annotation;

/**
 * Constraint processor to process the constraint of value matches as defined in the regex pattern
 */
public class PatternProcessor  implements Processor {
    @Override
    public boolean processConstraint(Object val, String fieldName, Annotation annotation) throws ValidationException {
        if(val == null){
            throw new ValidationException("Value is null for field " + fieldName, fieldName);
        }

        if(annotation == null || !(annotation instanceof Pattern)){
            throw new ValidationException("Invalid pattern defined for field " + fieldName, fieldName);
        }

        Pattern pattern = (Pattern) annotation;

        if(!val.toString().matches(pattern.value())){
            throw new ValidationException("Pattern Validation failed for " + fieldName);
        }

        return true;
    }
}
