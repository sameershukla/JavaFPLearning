package com.example.fp.basics.utils;

import com.example.fp.basics.types.Tuple;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionUtils {

    /**
     * Currying a BiFunction -> Function
     * @param biFun
     * @return
     * @param <A>
     * @param <B>
     * @param <C>
     */
    public static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> biFun) {
        return a -> b -> biFun.apply(a, b);
    }

    /**
     * Zip two functions
     * @param f
     * @param g
     * @return
     * @param <A>
     * @param <B>
     * @param <C>
     */
    public static <A, B, C> Function<A, Tuple<B, C>> zip(Function<A, B> f, Function<A, C> g){
        return a -> new Tuple<>(f.apply(a), g.apply(a));
    }

    /**
     * Zipping two functions and return left.
     * @param f
     * @param g
     * @return
     * @param <A>
     * @param <B>
     * @param <C>
     */
    public static <A, B, C> Function<A, B> zipLeft(Function<A, B> f, Function<A, C> g){
        return zip(f, g).andThen(Tuple :: _1);
    }

    /**
     * Zipping two functions and return right.
     * @param f
     * @param g
     * @return
     * @param <A>
     * @param <B>
     * @param <C>
     */
    public static <A, B, C> Function<A, C> zipRight(Function<A, B> f, Function<A, C> g){
        return zip(f, g).andThen(Tuple :: _2);
    }

    /**
     * Flatten
     */
    public static <A, B> Function<A, B> flatten(Function<A, Function<A, B>> f){
        return a -> f.apply(a).apply(a);
    }


}
