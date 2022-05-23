package com.oracle.exercise.validation.constraint.processor;

import com.oracle.exercise.validation.constraint.Min;
import com.oracle.exercise.validation.exception.ValidationException;

import java.lang.annotation.Annotation;

/**
 * Processor to process the Minimum validation on object field
 */
public class MinProcessor implements Processor {
    @Override
    public boolean processConstraint(Object val, String fieldName, Annotation annotation) throws ValidationException {
        if(val == null || !(val instanceof Integer)){
            //value cannot be null and must be integer type
            throw new ValidationException(fieldName + " can only be number", fieldName);
        }

        //annotation should be type of Min
        if(annotation == null || !(annotation instanceof Min)){
            throw new ValidationException("Invalid minimum value defined for field " + fieldName, fieldName);
        }

        Min min = (Min) annotation;

        if(Integer.valueOf(val.toString())<min.value()){
            throw new ValidationException("Minimum value required for field " + fieldName + " is " +min.value(), fieldName);
        }

        return true;
    }
}
