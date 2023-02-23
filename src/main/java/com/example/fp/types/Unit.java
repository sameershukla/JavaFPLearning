package com.example.fp.types;

/**
 *   Unit is a type that represents the absence of a meaningful value.
 *   It is similar to void in Java, but it is an actual type with a single value, also called Unit.
 */
public final class Unit {
    private Unit() {}

    private static final Unit INSTANCE = new Unit();

    public static Unit unit(){
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "Unit";
    }
}
