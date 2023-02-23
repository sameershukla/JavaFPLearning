package com.example.fp.chaining.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRestApiPipelineExample {

    @Test
    public void testApiSuccessful(){
        String outcome = RestClientPipelineExample.invoke("https://www.example.com");
        assertEquals("Service Invocation Successfully", outcome);
    }

    @Test
    public void testApiFailed(){

        Exception exception = assertThrows(RuntimeException.class, () -> {
            RestClientPipelineExample.invoke("example.com");
        });
        assertTrue(exception.getMessage().contains("no protocol: example.com"));
     }


}
