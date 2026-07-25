package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {
    @Test
    public void testCompare() {
        NumberComparator comp = new NumberComparator();
        assertEquals("Первое число больше", comp.compare(10, 5));
        assertEquals("Второе число больше", comp.compare(3, 8));
        assertEquals("Числа равны", comp.compare(5, 5));
    }
}
