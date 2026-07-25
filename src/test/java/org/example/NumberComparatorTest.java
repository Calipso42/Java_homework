package org.example;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberComparatorTest {
    @Test
    public void testCompare() {
        NumberComparator comp = new NumberComparator();
        assertEquals(comp.compare(10, 5), "Первое число больше");
        assertEquals(comp.compare(3, 8), "Второе число больше");
        assertEquals(comp.compare(5, 5), "Числа равны");
    }
}