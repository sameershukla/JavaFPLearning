package com.example.fp.functional.basics;

import com.example.fp.functional.tuple.Tuple;

import java.util.function.BiFunction;

public class BiFunctionChaining {

    /**
     * Function accepts 2 params and return Tuple
     * @param a
     * @param b
     * @return
     */
    private static Tuple<String, String> addText(String a, String b) {
        return new Tuple<String, String>(a.trim(), b.trim());
    }

    /**
     * Function accepts 2 params and remove special chars and create new Tuple
     * @param a
     * @param b
     * @return
     */
    private static Tuple<String, String> removeCharacters(String a, String b) {
        return new Tuple<String, String>(a.replaceAll("[^\\p{Alpha}]+", " "), b.replaceAll("[^\\p{Alpha}]+", " "));
    }

    /**
     * Function capitalize both params and return a tuple
     * @param a
     * @param b
     * @return
     */
    private static Tuple<String, String> capitalize(String a, String b) {
        return new Tuple<String, String>(a.toUpperCase(), b.toUpperCase());
    }

    /**
     * Pipeline
     */
    public static Tuple<String, String> letterChain(String input1, String input2){
        if(input1 == null || input2 == null)
            throw new IllegalArgumentException("Input cannot be null");

        BiFunction<String, String, Tuple<String, String>> pipeline = BiFunctionChaining::addText;
        return pipeline
                .andThen(t -> removeCharacters(t._1(), t._2()))
                .andThen(t -> capitalize(t._1(), t._2()))
                .apply(input1, input2);
    }

}
