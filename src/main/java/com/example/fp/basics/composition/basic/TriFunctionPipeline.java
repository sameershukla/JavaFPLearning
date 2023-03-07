package com.example.fp.basics.composition.basic;

import com.example.fp.basics.types.Tuple;

public class TriFunctionPipeline {

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
    /**
     * Letter Chaining
     * @param
     */
    public static Tuple<String, String> letterChain(String input1, String input2, String input3) {
        if(input1 == null || input2 == null || input3 == null)
            throw new IllegalArgumentException("Input cannot be null");

        TriFunction<String, String, String, Tuple<String, String>> pipeline = TriFunctionPipeline:: concatenate;
        return pipeline
                .andThen(TriFunctionPipeline:: capitalize)
                .apply(input1, input2, input3);
    }


}
