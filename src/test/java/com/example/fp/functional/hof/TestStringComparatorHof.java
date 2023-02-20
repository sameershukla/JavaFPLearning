package com.example.fp.functional.hof;

import com.example.fp.functional.currying.CurriedEmailComposer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestStringComparatorHof {

    @Test
    public void testStringEquals(){
        String outcome = StringComparatorHof.isEqual("Test", "Test");
        assertEquals("Equal Strings", outcome);
    }

    @Test
    public void testStringUnEquals(){
        String outcome = StringComparatorHof.isEqual("Test", "NoTest");
        assertEquals("UnEqual Strings", outcome);
    }

    @Test
    public void testNullStrings(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            StringComparatorHof.isEqual(null, "");
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }
}
