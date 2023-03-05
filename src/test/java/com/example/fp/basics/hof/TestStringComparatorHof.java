package com.example.fp.basics.hof;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class TestStringComparatorHof {

    @Test
    public void testStringEquals(){
        Optional<String> outcome = StringComparatorHof.isEqual("Test", "Test");
        assertEquals("Equal Strings", outcome.get());
    }

    @Test
    public void testStringUnEquals(){
        Optional<String> outcome = StringComparatorHof.isEqual("Test", "NoTest");
        assertEquals("UnEqual Strings", outcome.get());
    }

    @Test
    public void testNullStrings(){
        Optional<String> outcome = StringComparatorHof.isEqual(null, "abcd");
        assertTrue(outcome.isEmpty());
    }
}
