package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialCalculatorTest {
    @Test
    public void testFactorial() {
        FactorialCalculator calc = new FactorialCalculator();
        assertEquals(120, calc.calculate(5));
        assertEquals(1, calc.calculate(0));
    }

}
