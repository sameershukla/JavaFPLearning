package com.example.fp.functional.basics;

import com.example.fp.functional.tuple.Tuple;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

public class TestBiFunctionChaining {

    @Test
    public void testLetterChain(){
        Tuple<String, String> tuple =  BiFunctionChaining.letterChain("Hello", "World");
        String result = tuple._1() + tuple._2();
        assertEquals("HELLOWORLD", result);
    }

    @Test
    public void testLetterSpecialCharacter(){
        Tuple<String, String> tuple =  BiFunctionChaining.letterChain("Hello@#$@#$@#$", "#$#@$#@4World@#$@#$");
        String result = tuple._1() + tuple._2();
        assertEquals("HELLO  WORLD ", result);
    }

    @Test
    public void testLetterNull(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            BiFunctionChaining.letterChain(null, "qweqw");
            BiFunctionChaining.letterChain("qweqwe", null);
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }
}
