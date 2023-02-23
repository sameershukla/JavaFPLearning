package com.example.fp.chaining.hof;

import java.util.Arrays;
import java.util.function.Function;

public class IntArrayTransformerHof {

    private static Function<Integer, Integer> multiply = n -> n * 2;

    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5};
        for(int i=0; i < numbers.length; i++){
            numbers[i] = multiply.apply(numbers[i]);
        }
        System.out.println(Arrays.toString(numbers));
    }
}
