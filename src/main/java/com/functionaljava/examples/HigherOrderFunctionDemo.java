package com.functionaljava.examples;

import java.util.function.Predicate;

/**
 * Demonstrates higher-order functions in Java by using a generic process method
 * to count letters, digits, and special characters in a string.
 */
public class HigherOrderFunctionDemo {

    /**
     * Counts the letters in a given string.
     *
     * @param s the input string
     * @return the number of letters in the string
     */
    private static long countLetters(String s) {
        return process(s, Character::isLetter);
    }

    /**
     * Counts the digits in a given string.
     *
     * @param s the input string
     * @return the number of digits in the string
     */
    private static long countDigits(String s) {
        return process(s, Character::isDigit);
    }

    /**
     * Counts the special characters in a given string.
     *
     * @param s the input string
     * @return the number of special characters in the string
     */
    private static long countSpecialCharacters(String s) {
        return process(s, c -> !Character.isLetterOrDigit(c));
    }

    /**
     * Generic method that processes a string and counts characters that match
     * a specified predicate.
     *
     * @param s         the input string
     * @param predicate the condition to match each character
     * @return the count of characters matching the predicate
     */
    private static long process(String s, Predicate<Character> predicate) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(predicate)
                .count();
    }

    public static void main(String[] args) {
        String s = "Hello World! 123";

        System.out.println("Number of letters: " + countLetters(s));
        System.out.println("Number of digits: " + countDigits(s));
        System.out.println("Number of special characters: " + countSpecialCharacters(s));
    }
}
