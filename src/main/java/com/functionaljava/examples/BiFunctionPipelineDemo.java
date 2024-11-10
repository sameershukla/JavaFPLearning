package com.functionaljava.examples;

import com.functionaljava.types.Tuple;

import java.util.function.BiFunction;

/**
 * This class demonstrates a transformation pipeline using BiFunction for transforming two string inputs.
 * It processes two input strings through a series of transformations, returning a Tuple with the final results.
 */
public class BiFunctionPipelineDemo {

    /**
     * Trims leading and trailing whitespace from both inputs and returns a Tuple.
     *
     * @param a the first input string
     * @param b the second input string
     * @return a Tuple containing trimmed versions of a and b
     */
    private static Tuple<String, String> trim(String a, String b) {
        return new Tuple<>(a.trim(), b.trim());
    }

    /**
     * Removes special characters from both inputs, leaving only alphabetic characters, and returns a Tuple.
     *
     * @param a the first input string
     * @param b the second input string
     * @return a Tuple containing cleaned versions of a and b with special characters removed
     */
    private static Tuple<String, String> removeSpecialCharacters(String a, String b) {
        return new Tuple<>(a.replaceAll("[^\\p{Alpha}]+", " "), b.replaceAll("[^\\p{Alpha}]+", " "));
    }

    /**
     * Converts both input strings to uppercase and returns them as a Tuple.
     *
     * @param a the first input string
     * @param b the second input string
     * @return a Tuple containing uppercase versions of a and b
     */
    private static Tuple<String, String> toUpperCase(String a, String b) {
        return new Tuple<>(a.toUpperCase(), b.toUpperCase());
    }

    /**
     * Builds a transformation pipeline that:
     * 1. Trims whitespace from both inputs.
     * 2. Removes special characters, leaving only alphabetic characters.
     * 3. Converts the cleaned strings to uppercase.
     *
     * @param input1 the first input string
     * @param input2 the second input string
     * @return a Tuple containing the final transformed versions of input1 and input2
     */
    public static Tuple<String, String> letterChain(String input1, String input2) {
        if (input1 == null || input2 == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        // Define the pipeline to process the inputs
        BiFunction<String, String, Tuple<String, String>> pipeline = BiFunctionPipelineDemo::trim;

        return pipeline
                .andThen(t -> removeSpecialCharacters(t._1(), t._2()))
                .andThen(t -> toUpperCase(t._1(), t._2()))
                .apply(input1, input2);
    }
}
