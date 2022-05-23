package com.oracle.exercise.validation.constraint.processor;

import com.oracle.exercise.validation.constraint.Min;
import com.oracle.exercise.validation.exception.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.annotation.Annotation;

@RunWith(MockitoJUnitRunner.class)
public class MinProcessorTest {

    MinProcessor minProcessor;
    @Mock(extraInterfaces = {Min.class})
    Annotation annotationWithMin;

    String fieldName = "fieldName";

    @Before
    public void setup(){
        minProcessor = new MinProcessor();
    }

    @Test()
    public void testValueNotNumber(){

        Throwable t =Assert.assertThrows(ValidationException.class,
             ()->minProcessor.processConstraint("1", fieldName, null)
        );
        Assert.assertTrue(t.getMessage().equals(fieldName + " can only be number"));
    }

    @Test()
    public void testValueNull(){

        Throwable t =Assert.assertThrows(ValidationException.class,
             ()->minProcessor.processConstraint(null, fieldName, null)
        );
        Assert.assertTrue(t.getMessage().equals(fieldName + " can only be number"));
    }

    @Test()
    public void testAnnotationNull(){
        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->minProcessor.processConstraint(1, fieldName, null)
        );
        Assert.assertTrue(t.getMessage().equals("Invalid minimum value defined for field " + fieldName));
    }

    @Test()
    public void testAnnotationNotMin(){

        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->minProcessor.processConstraint(1, fieldName, Mockito.mock(Annotation.class))
        );
        Assert.assertTrue(t.getMessage().equals("Invalid minimum value defined for field " + fieldName));
    }

    @Test()
    public void testMinValueNotSet(){

        Mockito.when(((Min)annotationWithMin).value()).thenReturn(1);

        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->minProcessor.processConstraint(0, fieldName, annotationWithMin)
        );
        Assert.assertTrue(t.getMessage().equals("Minimum value required for field " + fieldName + " is 1"));
    }


    @Test
    public void testMinValueSet(){

        Mockito.when(((Min)annotationWithMin).value()).thenReturn(1);

        Assert.assertTrue(minProcessor.processConstraint(1, fieldName, annotationWithMin));
    }

}
