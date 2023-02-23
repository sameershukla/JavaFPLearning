package com.example.fp.chaining.basic;

import com.example.fp.types.Tuple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBiFunctionPipeline {

    @Test
    public void testLetterChain(){
        Tuple<String, String> tuple =  BiFunctionPipeline.letterChain("Hello", "World");
        String result = tuple._1() + tuple._2();
        assertEquals("HELLOWORLD", result);
    }

    @Test
    public void testLetterSpecialCharacter(){
        Tuple<String, String> tuple =  BiFunctionPipeline.letterChain("Hello@#$@#$@#$", "#$#@$#@4World@#$@#$");
        String result = tuple._1() + tuple._2();
        assertEquals("HELLO  WORLD ", result);
    }

    @Test
    public void testLetterNull(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            BiFunctionPipeline.letterChain(null, "qweqw");
            BiFunctionPipeline.letterChain("qweqwe", null);
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }
}
