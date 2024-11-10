package com.functionaljava.examples;

import java.util.Optional;
import java.util.function.Function;

/**
 * This class demonstrates creating a function pipeline to transform a string.
 * The pipeline executes the following transformations in order:
 * - `trimWhitespace`: Removes leading and trailing whitespace.
 * - `removeSpecialCharacters`: Removes any special characters, leaving only alphabetic characters.
 * - `toUpperCase`: Converts all letters to uppercase.
 *
 * This pipeline is wrapped in the `transform` method, which returns an Optional
 * to handle null or empty input strings.
 */
public class StringTransformationPipelineDemo {

    // Function to remove leading and trailing whitespace
    private static final Function<String, String> trimWhitespace = String::trim;

    // Function to remove special characters, leaving only alphabetic characters
    private static final Function<String, String> removeSpecialCharacters = x -> x.replaceAll("[^\\p{Alpha}]+", " ");

    // Function to convert string to uppercase
    private static final Function<String, String> toUpperCase = String::toUpperCase;

    /**
     * Applies a transformation pipeline to the input string.
     * The pipeline will trim whitespace, remove special characters, and capitalize the result.
     *
     * @param input the input string to be transformed
     * @return an Optional containing the transformed string, or Optional.empty() if input is null
     */
    public static String transform(String input) {
        return Optional.ofNullable(input)
                       .map(trimWhitespace
                               .andThen(removeSpecialCharacters)
                               .andThen(toUpperCase))
                .orElseGet(() -> new String("NONE"));
    }
}
