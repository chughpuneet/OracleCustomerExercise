package com.oracle.exercise.validation.constraint.processor;

import com.oracle.exercise.validation.exception.ValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotBlankProcessorTest {
    NotBlankProcessor notBlankProcessor = new NotBlankProcessor();

    @Test()
    public void testValueEmptyString(){

        Throwable t = Assert.assertThrows(ValidationException.class,
                ()->notBlankProcessor.processConstraint("", "", null)
        );
        Assert.assertTrue(t.getMessage().equals(" cannot be blank"));
    }

    @Test()
    public void testValueNull(){
        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->notBlankProcessor.processConstraint(null, "", null)
        );
        Assert.assertTrue(t.getMessage().equals(" cannot be blank"));
    }

    @Test()
    public void testValueNotNull(){
        Assert.assertTrue(notBlankProcessor.processConstraint("0", "", null));
    }

}
