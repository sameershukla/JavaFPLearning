package com.example.fp.functional.currying;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basics {


    static Function<String, String> addSuffix(String s) {
        return suffix -> s + suffix;
    }
    public static void main(String[] args) {
        Function<String, Function<String, Function<String, String>>> pipeline = a -> b -> c -> a + b + c;
        Function<String, String> addPrefix = str -> "Prefix" + str;

        Function<String, Function<String, String>> letterPipeline = letter -> addPrefix.andThen(addSuffix(letter));
        System.out.println(letterPipeline.apply("Hello").apply("World"));

        //Basic
        Function<Integer, Function<Integer, Integer>> p = i -> j -> i + j;
        System.out.println(p.apply(10).apply(20));

    }
}
