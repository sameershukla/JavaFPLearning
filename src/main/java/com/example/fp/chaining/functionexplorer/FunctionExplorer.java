package com.example.fp.chaining.functionexplorer;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExplorer {

    /**
     * Input is Function<String, Function<String,String>>
     *     Input to Function is String and output is a second function
     *       Input to second function is String and output is a String, hence on apply.apply a String is returned
     *        Input to first function (s1) output is a function (s2) -> s1 + s2
     *          Input to second function is (s2) output is s1 + s2
     *
     */
    private static String function(Function<String, Function<String, String>> f){
        return f.apply("Hello").apply("World");
    }

    private static Function<String, String> func(Function<String, Function<String, String>> f){
        return f.apply("Hello");
    }

    /**
     * In a way it's similar to function, to replace BiFunction with Function we need to use
     * Function<String, Function<String, String> and invoke apply twice.
     * @param b
     * @return
     */
    private static String biFunc(BiFunction<String, String, String> b){
        return b.apply("Hello", "World");
    }

    public static void main(String[] args) {

        // (s1) -> (s2) -> s1 + s2
        System.out.println(function((s1) -> (s2) -> s1 + s2));
        System.out.println(func(s1 -> (s2) -> s1 + s2).apply("World"));

        //bifunction (s1, s2) -> s1 + s2
        System.out.println(biFunc((s1, s2) -> s1 + s2));


    }
}
