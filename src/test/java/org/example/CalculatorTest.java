package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testArithmetic() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.add(7, 3));
        assertEquals(4, calc.subtract(7, 3));
        assertEquals(21, calc.multiply(7, 3));
        assertEquals(2.5, calc.divide(5, 2));
    }
}
