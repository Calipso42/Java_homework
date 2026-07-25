package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testArithmetic() {
        Calculator calc = new Calculator();
        assertEquals(calc.add(7, 3), 10);
        assertEquals(calc.subtract(7, 3), 4);
        assertEquals(calc.multiply(7, 3), 21);
        assertEquals(calc.divide(5, 2), 2.5);
    }
}