package com.example.fp.basics.hof;

import java.util.Optional;
import java.util.function.Function;

/**
 * This example has 2 methods isEqual and compare. IsEqual takes two String parameters, null checks them and invoke compare method
 * that takes both Strings as param and Higher Order Function which is a comparator
 * Function<String, Function<String, Integer>> meaning a Function that takes String and returns another Function that takes String and returns Integer
 */
public class StringComparatorHof {

    private static int compare(String s1, String s2, Function<String, Function<String, Integer>> cmp) {
        return cmp.apply(s1).apply(s2);
    }

    public static Optional<String> isEqual(String a, String b) {
        if (a == null || b == null) {
            return Optional.empty();
        }
        int output = compare(a, b, (String s1) -> (String s2) -> s1.compareTo(s2));
        return (output == 0) ? Optional.of("Equal Strings") : Optional.of("UnEqual Strings");
    }
}
