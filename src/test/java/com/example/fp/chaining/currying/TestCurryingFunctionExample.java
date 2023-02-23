package com.example.fp.chaining.currying;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCurryingFunctionExample {

    @Test
    public void testConcatenate(){
        String result = CurriedFunctionExample.concatenate("John", "Doe");
        assertEquals("JohnDoe", result);
    }

    @Test
    public void testConcatenateNullCheck(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            CurriedFunctionExample.concatenate(null, "Doe");
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }
}
