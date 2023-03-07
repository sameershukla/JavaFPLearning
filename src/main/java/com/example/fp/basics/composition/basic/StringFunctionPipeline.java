package com.example.fp.basics.composition.basic;

import java.util.Optional;
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

    public static Optional<String> letterChain(String input){
        if(input == null)
            return Optional.empty();

        Function<String, String> pipeline = StringFunctionPipeline:: addText;
        return Optional.of(pipeline
                            .andThen(StringFunctionPipeline:: removeSpecialCharacters)
                            .andThen(StringFunctionPipeline:: capitalize)
                            .apply(input));
    }
}

