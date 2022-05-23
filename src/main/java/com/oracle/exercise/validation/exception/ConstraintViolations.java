package com.oracle.exercise.validation.exception;

import java.util.List;

/**
 * Runtime Exception contains the list of all of the violations on the fields of the object
 */
public class ConstraintViolations extends RuntimeException{

    /**
     * list of the validations exception on the object
     */
    private List<ValidationException> constraintViolations;

    public ConstraintViolations(List<ValidationException> constraintViolations){
        this.constraintViolations = constraintViolations;
    }

    public void print() {
        if(null != constraintViolations){
            constraintViolations.stream().map(ValidationException::getMessage).forEach(System.out::println);
        }
    }

    public List<ValidationException> getConstraintViolations() {
        return constraintViolations;
    }

    public void setConstraintViolations(List<ValidationException> constraintViolations) {
        this.constraintViolations = constraintViolations;
    }
}
