package com.example.fp.basics.composition.advance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringFunctionPipeline {

    @Spy
    private StringFunctionPipeline stringChaining;

    @Test
    public void testLetterChain(){
       Assertions.assertEquals("HELLO WORLD", StringFunctionPipeline.letterChain("Hello World").get());
    }

    @Test
    public void testLetterSpecialCharacter(){
        Assertions.assertEquals("HELLO WORLD", StringFunctionPipeline.letterChain("Hello @#$@#$#@$#@$@#World").get());
    }

    @Test
    public void testLetterNull(){
        assertEquals(Optional.empty(), StringFunctionPipeline.letterChain(null));
    }


}
