package com.example.fp.utils;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryUtils {

    /**
     * Currying a BiFunction -> Function
     * @param biFun
     * @return
     * @param <A>
     * @param <B>
     * @param <C>
     */
    static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> biFun) {
        return a -> b -> biFun.apply(a, b);
    }

}
