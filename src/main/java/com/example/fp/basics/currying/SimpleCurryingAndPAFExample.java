package com.example.fp.basics.currying;

import java.util.function.Function;

public class SimpleCurryingAndPAFExample {



    static Function<Integer, Function<Integer, Function<Integer, Integer>>> sumWithThreeParams
                = (a)
                    -> (b)
                       -> (c) -> a + b + c;

    static Function<Integer, Function<Integer, Function<Integer, Function<Integer, Integer>>>> sumWithFourParams
            = (a)
                -> (b)
                    -> (c)
                     -> (d) -> a + b + c + d;

    static Function<Integer, Function<Integer, Integer>> partialSumWithTwoParams = sumWithThreeParams
                                                                                    .apply(5);

    static Function<Integer, Integer> partialSumWithOneParams = partialSumWithTwoParams
                                                                             .apply(10);

    public static void main(String[] args) {
        int c = 15;
        int result = partialSumWithOneParams.apply(c);
        System.out.println(result);
    }
}
