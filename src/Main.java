import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSum(5, 7));
        checkNumber(1);
        System.out.println(isNegative(-5));
        printStringWordNumber("Астон", 2);
        System.out.println(isYear(2026));
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 1;
        int b = 2;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 100500;
        if (value <= 0) {
            System.out.println("Kрасный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printStringWordNumber(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    public static boolean isYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(java.util.Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(java.util.Arrays.toString(arr));
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(java.util.Arrays.toString(arr));
    }

    public static void fillDiagonal() {
        // Создаем матрицу 3 на 3
        int[][] matrix = new int[3][3];

        // Цикл теперь работает до 3
        for (int i = 0; i < 3; i++) {
            matrix[i][i] = 1;
        }

        // Цикл вывода теперь тоже работает до 3
        for (int i = 0; i < 3; i++) {
            System.out.println(java.util.Arrays.toString(matrix[i]));
        }
    }
}