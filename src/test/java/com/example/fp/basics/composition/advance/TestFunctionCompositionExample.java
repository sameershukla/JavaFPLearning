package com.example.fp.basics.composition.advance;

import com.example.fp.basics.types.Unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFunctionCompositionExample {

    @Test
    public void testChain(){
        Unit unit = FunctionCompositionExample.compose(10);
        assertTrue(unit instanceof Unit);

        assertTrue(FunctionCompositionExample.chain(10) instanceof Unit);
    }
}
