package com.oracle.exercise.validation.constraint.processor;

import com.oracle.exercise.validation.exception.ValidationException;
import org.junit.Assert;
import org.junit.Test;

public class NotNullProcessorTest {
    private NotNullProcessor notNullProcessor = new NotNullProcessor();

    @Test()
    public void testValueNull(){
        Throwable t = Assert.assertThrows(ValidationException.class,
                ()->notNullProcessor.processConstraint(null, "", null)
        );
        Assert.assertTrue(t.getMessage().equals(" cannot be Null"));
    }

    @Test()
    public void testValueNotNull(){
        Assert.assertTrue(notNullProcessor.processConstraint("0", "", null));
    }
}
