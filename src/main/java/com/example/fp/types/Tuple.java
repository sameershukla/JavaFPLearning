package com.example.fp.types;

import java.util.Objects;

/**
 * Container for 2 params, Similar to Scala Tuple
 *
 * @param <A>
 * @param <B>
 */
public class Tuple<A, B> {

    A first;
    B second;

    public Tuple(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public A _1() {
        return first;
    }

    public B _2() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return first.equals(tuple.first) && second.equals(tuple.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
