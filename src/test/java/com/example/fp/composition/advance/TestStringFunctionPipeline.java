package com.example.fp.composition.advance;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringFunctionPipeline {

    @Spy
    private StringFunctionPipeline stringChaining;

    @Test
    public void testLetterChain(){
       assertEquals("HELLO WORLD", com.example.fp.composition.basic.StringFunctionPipeline.letterChain("Hello World"));
    }

    @Test
    public void testLetterSpecialCharacter(){
        assertEquals("HELLO WORLD", com.example.fp.composition.basic.StringFunctionPipeline.letterChain("Hello @#$@#$#@$#@$@#World"));
    }

    @Test
    public void testLetterNull(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            StringFunctionPipeline.letterChain(null);
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }


}
