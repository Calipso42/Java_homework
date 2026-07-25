package org.example;

public class NumberComparator {
    public String compare(int a, int b) {
        if (a > b) {
            return "Первое число больше";
        } else if (a < b) {
            return "Второе число больше";
        } else {
            return "Числа равны";
        }
    }
}
