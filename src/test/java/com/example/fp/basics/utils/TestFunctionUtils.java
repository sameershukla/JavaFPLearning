package com.example.fp.basics.utils;

import com.example.fp.basics.types.Tuple;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Function;

public class TestFunctionUtils {

    @Test
    public void zipTest(){
        Function<String, String> f = (s) -> "John";
        Function<String, String> g = (s) -> "Doe";
        Tuple<String, String> tuple = FunctionUtils.zip(f, g).apply("");
        assertEquals("John", tuple._1());
        assertEquals("Doe", tuple._2());
    }

    @Test
    public void zipLeftTest(){
        Function<String, String> f = (s) -> "John";
        Function<String, String> g = (s) -> "Doe";
        String left = FunctionUtils.zipLeft(f, g).apply("");
        assertEquals("John", left);
        assertNotEquals("Doe", left);
    }

    @Test
    public void zipRightTest(){
        Function<String, String> f = (s) -> "John";
        Function<String, String> g = (s) -> "Doe";
        String right = FunctionUtils.zipRight(f, g).apply("");
        assertEquals("Doe", right);
        assertNotEquals("John", right);
    }

}
