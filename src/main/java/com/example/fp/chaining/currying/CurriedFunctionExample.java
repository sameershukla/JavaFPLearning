package com.example.fp.chaining.currying;

import java.util.function.Function;

public class CurriedFunctionExample {

    private static Function<String, String> addPrefix = str ->  str;

    private static Function<String, String> addSuffix(String str) {
        return suffix -> str + suffix;
    }

    static String concatenate(String s1, String s2){
        if(s1 == null || s2 == null){
            throw new IllegalArgumentException("Input cannot be null");
        }
        Function<String, Function<String, String>> letterPipeline = letter -> addPrefix.andThen(addSuffix(letter));
        return letterPipeline.apply(s1).apply(s2);
    }


}
