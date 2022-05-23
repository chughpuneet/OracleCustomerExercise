package com.oracle.exercise.validation.constraint.processor;

import com.oracle.exercise.validation.constraint.Min;
import com.oracle.exercise.validation.constraint.Pattern;
import com.oracle.exercise.validation.exception.ValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.annotation.Annotation;

@RunWith(MockitoJUnitRunner.class)
public class PatternProcessorTest {

    private PatternProcessor processor = new PatternProcessor();

    @Mock(extraInterfaces = {Pattern.class})
    Annotation annotationWithPattern;

    @Test()
    public void testValueNull(){

        Throwable t = Assert.assertThrows(ValidationException.class,
                ()->processor.processConstraint(null, "", null)
        );
        Assert.assertTrue(t.getMessage().equals("Value is null for field "));
    }

    @Test()
    public void testAnnotationNull(){
        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->processor.processConstraint(1, "", null)
        );
        Assert.assertTrue(t.getMessage().equals("Invalid pattern defined for field "));
    }

    @Test()
    public void testAnnotationNotPatternIns(){

        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->processor.processConstraint(1, "", Mockito.mock(Annotation.class))
        );
        Assert.assertTrue(t.getMessage().equals("Invalid pattern defined for field "));
    }

    @Test()
    public void testPatternNotMatch(){

        Mockito.when(((Pattern)annotationWithPattern).value()).thenReturn("[\\d]+");

        Throwable t =Assert.assertThrows(ValidationException.class,
                ()->processor.processConstraint("a", "fieldName", annotationWithPattern)
        );
        Assert.assertTrue(t.getMessage().equals("Pattern Validation failed for fieldName"));
    }


    @Test()
    public void testPatternMatch(){

        Mockito.when(((Pattern)annotationWithPattern).value()).thenReturn("[\\d]+");


        Assert.assertTrue(processor.processConstraint(1, "fieldName", annotationWithPattern));
    }

}
