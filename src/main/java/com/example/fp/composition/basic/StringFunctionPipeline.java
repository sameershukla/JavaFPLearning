package com.example.fp.composition.basic;

import java.util.function.Function;

public class StringFunctionPipeline {

    private static String addText(String text){
        return text;
    }

    private static String removeSpecialCharacters(String text){
        return text.replaceAll("[^\\p{Alpha}]+", " ");
    }

    private static String capitalize(String text){
        return text.toUpperCase();
    }

    public static String letterChain(String input){
        if(input == null)
            throw new IllegalArgumentException("Input cannot be null");

        Function<String, String> pipeline = StringFunctionPipeline:: addText;
        return pipeline
                .andThen(StringFunctionPipeline:: removeSpecialCharacters)
                .andThen(StringFunctionPipeline:: capitalize)
                .apply(input);
    }
}
