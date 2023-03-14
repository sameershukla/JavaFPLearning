package com.example.fp.basics.composition.advance;

import com.example.fp.basics.types.Unit;

import java.util.function.Function;
import java.util.logging.Logger;

/**
 * This clas demonstrates attaching the logs of output of function execution.
 * Class has 3 functions which is called multiple, add and logOutput. Execution will be in order
 * multiply
 * add
 * logOutput
 *
 * The logOutput function simply Logs and returns nothing which is a Type called Unit.
 */
public class FunctionCompositionExample {

    static Logger logger = Logger.getLogger(FunctionCompositionExample.class.getName());

    private static Function<Integer, Integer> multiply = x -> x * 2;

    private static Function<Integer, Integer> add = x -> x + 2;

    private static Function<Integer, Unit> logOutput = x -> {
        logger.info("Data:" + x);
        return Unit.unit();
    };

    /**
     * Compose Example, first multiply is executed and output of multiply passed to add and then to logOutput.
     *
     * @param input
     * @return
     */
    public static Unit compose(Integer input) {
        Function<Integer, Unit> pipeline = logOutput
                                            .compose(add)
                                            .compose(multiply);
        return pipeline.apply(input);
    }

    /**
     * Simple Chain andThen example
     * @param input
     * @return
     */
    public static Unit chain(Integer input){
        Function<Integer, Unit> pipeline = multiply
                                            .andThen(add)
                                            .andThen(logOutput);
        return pipeline.apply(input);
    }
}
