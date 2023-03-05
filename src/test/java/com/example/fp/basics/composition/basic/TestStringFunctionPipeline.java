package com.example.fp.basics.composition.basic;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringFunctionPipeline {

    @Spy
    private StringFunctionPipeline stringChaining;

    @Test
    public void testLetterChain(){
       assertEquals("HELLO WORLD", StringFunctionPipeline.letterChain("Hello World"));
    }

    @Test
    public void testLetterSpecialCharacter(){
        assertEquals("HELLO WORLD", StringFunctionPipeline.letterChain("Hello @#$@#$#@$#@$@#World"));
    }

    @Test
    public void testLetterNull(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            StringFunctionPipeline.letterChain(null);
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }


}
