package com.example.fp.basics.composition.advance;

import java.util.Optional;
import java.util.function.Function;

/**
 * Sequence invoke toUpper, then concat and filter string
 */
public class StringFunctionPipeline {

    private static Function<String, String> addText = x -> x;

    private static Function<String, String> removeSpecialCharacters = x -> x.replaceAll("[^\\p{Alpha}]+", " ");

    private static Function<String, String> capitalize = x -> x.toUpperCase();

    public static Optional<String> letterChain(String input) {
        if (input == null)
            return Optional.empty();

        Function<String, String> pipeline = addText.andThen(removeSpecialCharacters).andThen(capitalize);
        return Optional.of(pipeline.apply(input));
    }

}
