package com.functionaljava.examples.basics;

import com.functionaljava.examples.StringTransformationPipelineDemo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTransformationPipelineTest {

    @Test
    public void testTransform_UppercaseTransformation() {
        // Test with a simple string
        String result = StringTransformationPipelineDemo.transform("Test");
        assertEquals("TEST", result, "Should convert 'Test' to uppercase.");

        // Test with mixed-case string
        result = StringTransformationPipelineDemo.transform("tEsTiNg");
        assertEquals("TESTING", result, "Should convert 'tEsTiNg' to uppercase.");

        // Test with lowercase string
        result = StringTransformationPipelineDemo.transform("functionaljava");
        assertEquals("FUNCTIONALJAVA", result, "Should convert 'functionaljava' to uppercase.");
    }

    @Test
    public void testTransform_WithNullInput() {
        // Test with null input
        String result = StringTransformationPipelineDemo.transform(null);
        assertEquals("NONE", result, "Should return 'NONE' when input is null.");
    }

    @Test
    public void testTransform_RemoveSpecialCharacters() {
        // Test with special characters and spaces
        String result = StringTransformationPipelineDemo.transform("Hello @World! #2023");
        assertEquals("HELLO WORLD ", result, "Should remove special characters and convert to uppercase.");

        // Test with only special characters
        result = StringTransformationPipelineDemo.transform("$$$!!!@@@");
        assertEquals(" ", result, "Should return an empty string when input has only special characters.");
    }

    @Test
    public void testTransform_WithWhitespace() {
        // Test with leading and trailing whitespace
        String result = StringTransformationPipelineDemo.transform("   Java Programming   ");
        assertEquals("JAVA PROGRAMMING", result, "Should trim whitespace and convert to uppercase.");

        // Test with multiple spaces within text
        result = StringTransformationPipelineDemo.transform("Functional   Programming");
        assertEquals("FUNCTIONAL PROGRAMMING", result, "Should preserve single spaces and remove extra spaces.");
    }
}
