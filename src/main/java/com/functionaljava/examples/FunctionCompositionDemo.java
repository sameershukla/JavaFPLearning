package com.functionaljava.examples;

import com.functionaljava.types.Unit;

import java.util.function.Function;
import java.util.logging.Logger;


/**
 * This class demonstrates the use of function composition in Java.
 * It provides two methods, `compose` and `chain`, to showcase different ways of chaining functions.
 * The function pipeline multiplies an integer by 2, adds 2 to it, and logs the result.
 *
 *   Execution order:
 * - `compose` method: executes `multiply` first, then `add`, then `logOutput`.
 * - `chain` method: executes `multiply` first, then `add`, then `logOutput`.
 */
public class FunctionCompositionDemo {

    static Logger logger = Logger.getLogger(FunctionCompositionDemo.class.getName());

    // Function to multiply input by 2
    private static Function<Integer, Integer> multiply = x -> x * 2;

    // Function to add 2 to input
    private static Function<Integer, Integer> add = x -> x + 2;

    // Function to log output and return a Unit type to indicate no further result
    private static Function<Integer, Unit> logOutput = x -> {
        logger.info("Final Output: " + x);
        return Unit.unit();
    };

    /**
     * Compose Example: first `multiply` is executed, then `add`, then `logOutput`.
     * `compose` executes functions in reverse order (right to left).
     *
     * @param input the initial input integer to be processed
     * @return a Unit value indicating completion of the chain
     */
    public static Unit compose(Integer input) {
        Function<Integer, Unit> pipeline = logOutput
                .compose(add)
                .compose(multiply); // Right-to-left execution
        return pipeline.apply(input);
    }

    /**
     * Chain Example with `andThen`: executes `multiply` first, then `add`, then `logOutput`.
     * `andThen` executes functions in the order they are written (left to right).
     *
     * @param input the initial input integer to be processed
     * @return a Unit value indicating completion of the chain
     */
    public static Unit chain(Integer input) {
        Function<Integer, Unit> pipeline = multiply
                .andThen(add)
                .andThen(logOutput); // Left-to-right execution
        return pipeline.apply(input);
    }
}
