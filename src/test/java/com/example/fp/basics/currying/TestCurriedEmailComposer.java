package com.example.fp.basics.currying;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TestCurriedEmailComposer {

    @Test
    public void testEmail(){
        String email = CurriedEmailComposer.email("sameer.shukla", "gmail").get();
        assertEquals("sameer.shukla@gmail.com", email);
    }

    @Test
    public void testEmailNull(){
        assertEquals(Optional.empty(), CurriedEmailComposer.email(null, ""));
    }
}
