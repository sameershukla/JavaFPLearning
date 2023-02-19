package com.example.fp.functional.currying;

import java.util.function.Function;

public class CurriedStringComparator {

    private static int compare(String s1, String s2, Function<String, Function<String, Integer>> cmp){
        return cmp.apply(s1).apply(s2);
    }

    public static String isEqual(String a, String b){
        int output = compare(a, b,(String s1) -> (String s2) -> s1.compareTo(s2));
        return (output == 0) ? "Equal Strings" : "UnEqual Strings";
    }
}
