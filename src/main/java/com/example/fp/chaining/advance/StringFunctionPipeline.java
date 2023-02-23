package com.example.fp.chaining.advance;

import java.util.function.Function;

/**
 * Sequence invoke toUpper, then concat and filter string
 */
public class StringFunctionPipeline {

    private static Function<String, String> addText = x -> x;

    private static Function<String, String> removeSpecialCharacters = x -> x.replaceAll("[^\\p{Alpha}]+", " ");

    private static Function<String, String> capitalize = x -> x.toUpperCase();

    public static String letterChain(String input) {
        if (input == null) throw new IllegalArgumentException("Input cannot be null");

        Function<String, String> pipeline = addText.andThen(removeSpecialCharacters).andThen(capitalize);
        return pipeline.apply(input);
    }

}
