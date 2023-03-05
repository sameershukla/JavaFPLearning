package com.example.fp.basics.composition.advance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringFunctionPipeline {

    @Spy
    private StringFunctionPipeline stringChaining;

    @Test
    public void testLetterChain(){
       Assertions.assertEquals("HELLO WORLD", com.example.fp.basics.composition.basic.StringFunctionPipeline.letterChain("Hello World"));
    }

    @Test
    public void testLetterSpecialCharacter(){
        Assertions.assertEquals("HELLO WORLD", com.example.fp.basics.composition.basic.StringFunctionPipeline.letterChain("Hello @#$@#$#@$#@$@#World"));
    }

    @Test
    public void testLetterNull(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            StringFunctionPipeline.letterChain(null);
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }


}
