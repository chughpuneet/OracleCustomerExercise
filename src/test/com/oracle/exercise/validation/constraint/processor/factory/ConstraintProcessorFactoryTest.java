package com.oracle.exercise.validation.constraint.processor.factory;

import com.oracle.exercise.validation.constraint.processor.MinProcessor;
import com.oracle.exercise.validation.constraint.processor.NotBlankProcessor;
import com.oracle.exercise.validation.constraint.processor.NotNullProcessor;
import com.oracle.exercise.validation.constraint.processor.PatternProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConstraintProcessorFactoryTest {
    @Test
    public void testMinProcessorInstance(){
        Assert.assertTrue(ConstraintProcessorFactory.getFactory().getConstraintProcessor("Min") instanceof MinProcessor);
    }

    @Test
    public void testNotNullProcessorInstance(){
        Assert.assertTrue(ConstraintProcessorFactory.getFactory().getConstraintProcessor("NotNull") instanceof NotNullProcessor);
    }

    @Test
    public void testNotBlankProcessorInstance(){
        Assert.assertTrue(ConstraintProcessorFactory.getFactory().getConstraintProcessor("NotBlank") instanceof NotBlankProcessor);
    }

    @Test
    public void testPatternProcessorInstance(){
        Assert.assertTrue(ConstraintProcessorFactory.getFactory().getConstraintProcessor("Pattern") instanceof PatternProcessor);
    }
}
