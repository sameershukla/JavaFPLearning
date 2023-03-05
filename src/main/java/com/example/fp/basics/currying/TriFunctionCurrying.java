package com.example.fp.basics.currying;

import com.example.fp.basics.types.Tuple;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TriFunctionCurrying {


    private static Tuple<String, String> removeCharacters(String a, String b) {
        return new Tuple<String, String>(a.replaceAll("[^\\p{Alpha}]+", " "), b.replaceAll("[^\\p{Alpha}]+", " "));
    }

    private static Tuple<String, String> capitalize(String a, String b) {
        return new Tuple<String, String>(a.toUpperCase(), b.toUpperCase());
    }


    public static void main(String[] args) {
        Function<String, Function<String, Function<String, Tuple<String, String>>>> pipeline = (f) -> (m -> (l -> new Tuple<String, String>(f, m + " " + l)));
        Tuple<String, String> tuple = pipeline.apply("Java").apply("Programming234234#$@#$").apply("Language");

        BiFunction<String, String, Tuple<String, String>> p = TriFunctionCurrying::removeCharacters;
        Tuple<String, String> result = p.andThen(x -> capitalize(x._1(), x._2())).andThen(x -> removeCharacters(x._1(), x._2()))
                .apply(tuple._1(), tuple._2());
        System.out.println(result);
    }

}
