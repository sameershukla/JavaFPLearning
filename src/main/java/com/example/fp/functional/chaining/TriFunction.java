package com.example.fp.functional.chaining;

/**
 * TriFunction is a function that represents method with 3 parameters and a return type
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <R>
 */
@FunctionalInterface
public interface TriFunction<A, B, C, R> {
    R apply(A a, B b, C c);

    default <R> TriFunction<A, B, C, R> andThen(TriFunction<A, B, C, R> after) {
        return (A a, B b, C c) -> after.apply(a,b,c);
    }
}
