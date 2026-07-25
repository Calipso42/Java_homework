package org.example;



import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleAreaCalculatorTest {
    @Test
    public void testArea() {
        TriangleAreaCalculator calc = new TriangleAreaCalculator();
        assertEquals(calc.calculateArea(4, 5), 10.0);
    }
}
