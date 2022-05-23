package com.oracle.exercise.validation.validator;

import com.oracle.exercise.validation.exception.ValidationException;
import org.junit.Assert;
import org.junit.Test;

public class StringInputValidatorTest {
    StringInputValidator obj1 = StringInputValidator.getStringInputValidator();

    @Test
    public void testSingleton(){
        StringInputValidator obj2 = StringInputValidator.getStringInputValidator();
        Assert.assertTrue(obj1.equals(obj2));
    }

    @Test()
    public void testInputNull(){
        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->obj1.validate(null)
        );
        Assert.assertTrue(t.getMessage().equals("Customer details cannot be null"));
    }

    @Test()
    public void testCustomerIdNotDigit(){
        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->obj1.validate("a,,,,,")
        );
        Assert.assertTrue(t.getMessage().equals("Customer details are in the format of customerId,contractId,geozone,teamcode,projectcode,buildduration for example - 2343225,2345,us_east,RedTeam,ProjectApple,3445s"));
    }

    @Test()
    public void testContractIdNotDigit(){
        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->obj1.validate(",a,,,,")
        );
        Assert.assertTrue(t.getMessage().equals("Customer details are in the format of customerId,contractId,geozone,teamcode,projectcode,buildduration for example - 2343225,2345,us_east,RedTeam,ProjectApple,3445s"));
    }

    @Test()
    public void testValidInput(){
        Assert.assertTrue(obj1.validate("2343225,2345,us_east,RedTeam,ProjectApple,3445s"));
    }

}
