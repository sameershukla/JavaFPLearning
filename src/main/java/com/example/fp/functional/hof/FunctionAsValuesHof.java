package com.example.fp.functional.hof;

import java.util.Arrays;
import java.util.function.Function;

/**
 * In this example, we created 2 HOF's multiply and add
 * then we chained them together to form a pipeline
 * during array iteration applied chained function on every integer.
 */
public class FunctionAsValuesHof {

    private static Function<Integer, Integer> multiply = n -> n * 2;

    private static Function<Integer, Integer> add = n -> n + 2;

    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5};
        Function<Integer, Integer> pipeline = multiply.andThen(add);

        for(int i=0; i < numbers.length; i++){
            numbers[i] = pipeline.apply(numbers[i]);
        }
        System.out.println(Arrays.toString(numbers));
    }
}
