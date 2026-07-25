package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAreaCalculatorTest {
    @Test
    public void testArea() {
        TriangleAreaCalculator calc = new TriangleAreaCalculator();
        // Основание 4 * высота 5 = площадь 10.0
        assertEquals(10.0, calc.calculateArea(4, 5));
    }
}
