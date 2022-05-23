package com.oracle.exercise.validation.constraint.processor.factory;

import com.oracle.exercise.validation.constraint.processor.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory to get the constraint processors
 */
public final class ConstraintProcessorFactory {

    private static ConstraintProcessorFactory _this;
    private Map<String, Processor> registeredProcessors = new HashMap<>();
    private ConstraintProcessorFactory(){
        super();
        //name should be unique and same as the name of the constraint
        registeredProcessors.put("Min", new MinProcessor());
        registeredProcessors.put("NotNull", new NotNullProcessor());
        registeredProcessors.put("NotBlank", new NotBlankProcessor());
        registeredProcessors.put("Pattern", new PatternProcessor());
    }

    public static ConstraintProcessorFactory getFactory(){
        if(null != _this) return _this;

        synchronized (ConstraintProcessorFactory.class){
            _this = new ConstraintProcessorFactory();
            return _this;
        }
    }

    /**
     * Get a constraint processor by it's name
     *
     * @param processorName name of the processor, it should be same os the name of the constraint
     *
     * @return instance of processor to process the constraint
     */
    public Processor getConstraintProcessor(String processorName){
        if(null == processorName) return null;

        return registeredProcessors.get(processorName);

    }

}
