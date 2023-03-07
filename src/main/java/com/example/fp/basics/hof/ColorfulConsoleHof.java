package com.example.fp.basics.hof;

import com.example.fp.basics.types.Unit;
import java.util.function.Function;
import java.util.logging.Logger;

/**
 * We have 3 functions
 *    1. addColor - that add color to the String - returns a function
 *    2. toUpper - that converts String to Upper case - returns a function
 *    3. logOutput function that takes a String and addColor and toUpper function as param and apply in order.
 */
public class ColorfulConsoleHof {

    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    static Logger logger = Logger.getLogger(ColorfulConsoleHof.class.getName());

    private static Unit logOutput(String s, Function<String, String> colorHof, Function<String, String> strFunc){
        logger.info(colorHof.apply(strFunc.apply(s)));
        return Unit.unit();
    }
    private static Function<String, String> toUpper = (s) -> s.toUpperCase();
    private static Function<String, String> addColor = (s) -> YELLOW_BOLD + s;

    public static void main(String[] args) {
        String input = "Functional Programming in Java";
        logOutput(input, addColor, toUpper);
    }

}
