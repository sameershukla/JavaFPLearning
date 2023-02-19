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
        return new Tuple<String, String>(a, b);
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
     * Main
     * @param args
     */
    public static void main(String[] args) {
        BiFunction<String, String, Tuple<String, String>> pipeline = BiFunctionChaining::addText;
        Tuple<String, String> resultTuple = pipeline
                .andThen(t -> removeCharacters(t._1(), t._2()))
                .andThen(t -> capitalize(t._1(), t._2()))
                .apply("Java@#$%%%Programming%", "$##Language");
        System.out.println(resultTuple._1() + " " + resultTuple._2());
    }
}
