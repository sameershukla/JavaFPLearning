package com.functionaljava.examples.basics;

import com.functionaljava.examples.FunctionCompositionDemo;
import com.functionaljava.types.Unit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionCompositionDemoTest {

    private final ByteArrayOutputStream logCapture = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(logCapture));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testComposeLogsFinalOutput() {
        Unit result = FunctionCompositionDemo.compose(10);

        String logs = logCapture.toString();
        System.out.println("LOGS:"+logs);
        assertTrue(logs.contains("INFO: Final Output: 22"));
    }
}