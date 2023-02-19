package com.example.fp.functional.currying;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basics {

    private static String split(String a){
        String[] s = a.split("-");
        return Arrays.stream(s).collect(Collectors.joining());
    }

    private static String capitalize(String b){
        return b.toUpperCase();
    }

    private static String replace(String c){
        return c.replaceAll("A", "E");
    }


    public static void main(String[] args) {
        Function<String, Function<String, Function<String, String>>> pipeline = a -> b -> c -> a + b + c;

    }
}
