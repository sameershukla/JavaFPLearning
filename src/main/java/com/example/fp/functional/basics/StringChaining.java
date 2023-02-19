package com.example.fp.functional.basics;

import java.util.Objects;
import java.util.function.Function;

public class StringChaining {

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

        Function<String, String> pipeline = StringChaining:: addText;
        return pipeline
                .andThen(StringChaining:: removeSpecialCharacters)
                .andThen(StringChaining:: capitalize)
                .apply(input);
    }

}
