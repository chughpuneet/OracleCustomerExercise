package com.oracle.exercise.validation.exception;

/**
 * Runtime exception for validation failure
 */
public class ValidationException extends RuntimeException{
    /**
     * Name of the field on which validation is failed
     */
    private String fieldName;

    public ValidationException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public ValidationException(String message){
        super(message);
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
