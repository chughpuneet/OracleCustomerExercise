package com.oracle.exercise.validation.validator;

import com.oracle.exercise.validation.constraint.processor.factory.ConstraintProcessorFactory;
import com.oracle.exercise.validation.constraint.processor.Processor;
import com.oracle.exercise.validation.exception.ConstraintViolations;
import com.oracle.exercise.validation.exception.ValidationException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Validator to validate the object of type T by parsing it's fields and validating all of the annotations defined on it
 *
 * @param <T> type of the object on which validation needs to be performed
 */
public final class Validator<T> {

    public boolean validateFields(T obj) throws ConstraintViolations {
        AtomicBoolean fieldsValidationResult = new AtomicBoolean(true);
        Class clazz = obj.getClass();
        final List<ValidationException> validationExceptions = new ArrayList<>();
        //iterate over each field and check if it has annotation
        Arrays.stream(clazz.getDeclaredFields()).filter(field -> field.getAnnotations().length > 0)
                .forEach(field -> {
                    try {
                        //validate the field with annotation
                        boolean bool = validateField(field,obj);
                        fieldsValidationResult.set(fieldsValidationResult.get() && bool );
                    }catch (ConstraintViolations e){
                        validationExceptions.addAll(e.getConstraintViolations());
                    }
        });

        if(!validationExceptions.isEmpty()){
            throw new ConstraintViolations(validationExceptions);
        }
        return fieldsValidationResult.get();
    }

    /**
     * validate the Object field by going through all of the constraint annotations defined on it.
     * The constraint processor needs to be registered in the factory
     *
     * @param field, field instance of the object
     * @param obj, object on the which the validation needs to be performed
     *
     * @return true, if validation is passed
     *
     * @throws ConstraintViolations
     */
    public boolean validateField(Field field, T obj) throws ConstraintViolations{
        field.setAccessible(true);
        AtomicBoolean fieldAnnotationsValidationResult = new AtomicBoolean(true);
        final List<ValidationException> validationExceptions = new ArrayList<>();
        Arrays.stream(field.getAnnotations()).forEach(annotation -> {
            try {
                //get a processor for each annotation

                Processor processor =  ConstraintProcessorFactory.getFactory()
                        .getConstraintProcessor(annotation.annotationType().getSimpleName());

                if(processor != null){
                    //can only be null if it's processor not registered
                    Object fieldValue = field.get(obj);
                    try {
                        //process the constraint
                        Boolean bool = processor.processConstraint(fieldValue, field.getName(), annotation);
                        fieldAnnotationsValidationResult.set(
                                fieldAnnotationsValidationResult.get()
                                        && bool);
                    }catch (ValidationException e){
                        validationExceptions.add(e);
                    }
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error in validation ", e );
            }
        });
        if(!validationExceptions.isEmpty()){
            throw new ConstraintViolations(validationExceptions);
        }
        return fieldAnnotationsValidationResult.get();
    }
}
