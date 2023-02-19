package com.example.fp.functional.basics;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringChaining {

    @Spy
    private StringChaining stringChaining;

    @Test
    public void testLetterChain(){
       assertEquals("HELLO WORLD", StringChaining.letterChain("Hello World"));
    }

    @Test
    public void testLetterSpecialCharacter(){
        assertEquals("HELLO WORLD", StringChaining.letterChain("Hello @#$@#$#@$#@$@#World"));
    }

    @Test
    public void testLetterNull(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            StringChaining.letterChain(null);
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }


}
