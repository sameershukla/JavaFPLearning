package com.example.fp.basics.hof;

import com.example.fp.basics.types.Unit;

import java.util.function.Function;
import java.util.logging.Logger;

/**
 * We have 2 functions
 *   toUpper -> takes a String and converts to Uppercase -> return function that should be applied later.
 *   addColor -> takes a String and add Color to it
 *   logOutput -> takes a String and 2 HOF's and applied both HOF's on the String.
 */
public class ConsoleFormatterHof {

    static Logger logger = Logger.getLogger(ConsoleFormatterHof.class.getName());
    private static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW

    private static Function<String, String> toUpper = (s) -> s.toUpperCase();

    private static Function<String, String> addColor = (s) -> YELLOW_BOLD + s;

    private static Unit logOutput(String s, Function<String, String> toUpper, Function<String, String> addColor){
        logger.info(addColor.apply(toUpper.apply(s)));
        return Unit.unit();
    }

    public static void main(String[] args) {
        String input = "Java Programming Language";
        logOutput(input, toUpper, addColor);
    }
}