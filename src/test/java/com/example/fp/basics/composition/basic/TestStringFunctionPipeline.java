package com.example.fp.basics.composition.basic;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringFunctionPipeline {

    @Spy
    private StringFunctionPipeline stringChaining;

    @Test
    public void testLetterChain(){
       assertEquals("HELLO WORLD", StringFunctionPipeline.letterChain("Hello World").get());
    }

    @Test
    public void testLetterSpecialCharacter(){
        assertEquals("HELLO WORLD", StringFunctionPipeline.letterChain("Hello @#$@#$#@$#@$@#World").get());
    }

    @Test
    public void testLetterNull(){
        assertEquals(Optional.empty(), StringFunctionPipeline.letterChain(null));
    }


}
