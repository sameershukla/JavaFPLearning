package com.example.fp.functional.currying;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basics {

    static Function<String, String> addPrefix = str ->  "MR.-" + str;

    static Function<String, String> addSuffix(String str) {
        return suffix -> str + suffix;
    }

    private static String getS1(){
        return "A";
    }

    private static String getS2(){
        return "B";
    }

    private static int compare(String s1, String s2, Function<String, Function<String, Integer>> cmp){
        return cmp.apply(s1).apply(s2);
    }

    public static void main(String[] args) {
        Function<String, Function<String, String>> letterPipeline = letter -> addPrefix.andThen(addSuffix(letter));
        String result = letterPipeline.apply("Hello").apply("World");
        System.out.println(result); // Output: "PrefixHelloWorldSuffix"



        Function<String, Function<String, Integer>> cmp = (String s1) -> (String s2) -> s1.compareTo(s2);
        System.out.println(compare("A", "A", (String s1) -> (String s2) -> s1.compareTo(s2)));
    }


}
