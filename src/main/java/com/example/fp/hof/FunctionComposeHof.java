package com.example.fp.hof;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This examples demonstrates the compose function, idea here is to chaining to multiply the number with 2,
 * then add with 2 and filter all the numbers those are greater than 10. If you try to use andThen it will be syntactically
 * wrong because we are trying to return a Predicate eventually to apply filtering.
 */
public class FunctionComposeHof {

    private static Function<Integer, Integer> multiply = x -> {
        System.out.println("Inside Add:" +x);
        return x * 2;
    };
    private static Function<Integer, Integer> add = x -> {
        System.out.println("Inside multiply:" +x);
        return x + 2;
    };
    private static Function<Integer, Predicate<Integer>> isGreaterThan =  i -> x -> {
        System.out.println("X Filter :" + x);
        return x >= 10;
    };


    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5};
        Function<Integer, Integer> math = multiply.andThen(add);
        Function<Integer, Predicate<Integer>>  pipeline = isGreaterThan.compose(math);
      
        List<Integer> filteredList = new ArrayList<>();
        for(int i=0; i < numbers.length; i++){
            int n = numbers[i];
            Predicate<Integer> f = pipeline.apply(n);
            if(!f.test(n)){
                filteredList.add(n);
            }
        }
        System.out.println(filteredList);
    }
}
