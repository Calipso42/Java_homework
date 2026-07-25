package org.example;


import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialCalculatorTest {
    @Test
    public void testFactorial() {
        FactorialCalculator calc = new FactorialCalculator();
        assertEquals(calc.calculate(5), 120);
        assertEquals(calc.calculate(0), 1);
    }
}
