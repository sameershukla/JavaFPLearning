package com.functionaljava.examples;

import java.util.function.Function;

/**
 * Demonstrates the concept of currying and partial application in Java.
 * BiFunction and TriFunction have limitations, and currying provides a flexible approach
 * for multi-parameter functions, breaking them down into single-parameter functions.
 */
public class FunctionCurryingDemo {

    // Currying: A function that takes one parameter and returns another function for the next parameter
    static Function<Integer, Function<Integer, Function<Integer, Integer>>> sumWithThreeParams
            = a -> b -> c -> a + b + c;

    // Currying with four parameters
    static Function<Integer, Function<Integer, Function<Integer, Function<Integer, Integer>>>> sumWithFourParams
            = a -> b -> c -> d -> a + b + c + d;

    // Partial Application: Fixing the first parameter (5) and leaving the rest to be provided later
    static Function<Integer, Function<Integer, Integer>> partialSumWithTwoParams = sumWithThreeParams.apply(5);

    // Further Partial Application: Fixing the second parameter (10), leaving only the final parameter to be provided
    static Function<Integer, Integer> partialSumWithOneParam = partialSumWithTwoParams.apply(10);

    public static void main(String[] args) {
        // Final parameter provided here
        int c = 15;
        int result = partialSumWithOneParam.apply(c);  // Result is 5 + 10 + 15 = 30
        System.out.println("Final result of partially applied curried function: " + result);

        // Demonstrating full currying with sumWithFourParams (all parameters provided one by one)
        int fullyCurriedResult = sumWithFourParams
                .apply(1)
                .apply(2)
                .apply(3)
                .apply(4);  // Result is 1 + 2 + 3 + 4 = 10
        System.out.println("Result of fully curried function with four parameters: " + fullyCurriedResult);
    }
}
