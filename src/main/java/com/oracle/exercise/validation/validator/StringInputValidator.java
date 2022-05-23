package com.oracle.exercise.validation.validator;

import com.oracle.exercise.validation.exception.ValidationException;

/**
 * Custom validator to validate the user input, it just does the high level validation.
 * Business validation can only be performed by annotating the corresponding field
 */
public final class StringInputValidator {


    private static StringInputValidator _this;

    private StringInputValidator(){
        super();
    }

    public static StringInputValidator getStringInputValidator(){
        if(null != _this){
            return _this;
        }

        synchronized (StringInputValidator.class){
            _this  = new StringInputValidator();
            return _this;
        }
    }
    public boolean validate(String commaSepStr) throws ValidationException {
        if(null == commaSepStr){
            throw new ValidationException("Customer details cannot be null");
        }else if(!commaSepStr.matches("\\d*,\\d*,.*,.*,.*,.*")){
            throw new ValidationException("Customer details are in the format of customerId,contractId,geozone,teamcode,projectcode,buildduration for example - 2343225,2345,us_east,RedTeam,ProjectApple,3445s");
        }
       return true;
    }
}
