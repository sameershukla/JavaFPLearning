package com.example.fp.functional.chaining;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class TestRestApiPipelineExample {

    @Test
    public void testApiSuccessful(){
        String outcome = RestApiPipelineExample.invoke("https://www.example.com");
        assertEquals("Service Invocation Successfully", outcome);
    }

    @Test
    public void testApiFailed(){

        Exception exception = assertThrows(RuntimeException.class, () -> {
            RestApiPipelineExample.invoke("example.com");
        });
        assertTrue(exception.getMessage().contains("no protocol: example.com"));
     }
}
