package com.example.fp.functions.chaining;

import com.example.fp.functions.tuple.Tuple;

public class TriFunctionChaining {

    /**
     * Method accepts 3 parameters, concatenate and return a Tuple
     * @param first
     * @param middle
     * @param last
     * @return
     */
    private static Tuple<String, String> concatenate(String first, String middle, String last){
        return new Tuple<>(first, " "+ middle + " " + last);
    }

    /**
     * remove special characters from the data
     * @param first
     * @param middle
     * @param last
     * @return
     */
    private static Tuple<String, String> removeCharacters(String first, String middle, String last){
        String lastName = middle.replaceAll("[^\\p{Alpha}]+", " ") + " " + last.replaceAll("[^\\p{Alpha}]+", " ");
        return new Tuple<>(first.replaceAll("[^\\p{Alpha}]+", " "), " "+ lastName);
    }

    /**
     * Capitalization
     * @param first
     * @param middle
     * @param last
     * @return
     */
    private static Tuple<String, String> capitalize(String first, String middle, String last){
        String lastName = middle.toUpperCase() + " " + last.toUpperCase();
        return new Tuple<>(first.toUpperCase(), " "+ lastName);
    }

    public static void main(String[] args) {
        TriFunction<String, String, String, Tuple<String, String>> pipeline = TriFunctionChaining :: concatenate;
        Tuple<String, String> resultTuple = pipeline
                                                .andThen(TriFunctionChaining :: removeCharacters)
                                                .andThen(TriFunctionChaining :: capitalize)
                                                .apply("Sameer", "K", "Shukla");
        System.out.println(resultTuple._1() + " " + resultTuple._2());
    }
}
