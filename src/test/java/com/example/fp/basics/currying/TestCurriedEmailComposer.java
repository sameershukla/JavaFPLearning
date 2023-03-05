package com.example.fp.basics.currying;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCurriedEmailComposer {

    @Test
    public void testEmail(){
        String email = CurriedEmailComposer.email("sameer.shukla", "gmail");
        assertEquals("sameer.shukla@gmail.com", email);
    }

    @Test
    public void testEmailNull(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            CurriedEmailComposer.email(null, "");
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }
}
