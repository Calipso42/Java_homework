public class Main {

    public static void main(String[] args) {
        // Задание 1
        printThreeWords();

        // Задание 2
        checkSumSign();

        // Задание 3
        printColor();

        // Задание 4
        compareNumbers();
    }

    // Задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Задание 2
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

    // Задание 3
    public static void printColor() {
        int value = 100500;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Задание 4
    public static void compareNumbers() {
        int a = 5; // Можете поставить любое число
        int b = 3; // Можете поставить любое число

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}