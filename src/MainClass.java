public class MainClass {

    public static int checkAndSum(String[][] matrix) throws MyArraySizeException, MyArrayDataException {

        // Задание 1
        if (matrix.length != 4) {
            throw new MyArraySizeException("Размер массива неверный! Должно быть 4 строки. У тебя: " + matrix.length);
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != 4) {
                throw new MyArraySizeException("В строке под номером " + i + " должно быть 4 колонки.");
            }
        }

        // Задание 2
        int totalSum = 0;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {

                    totalSum = totalSum + Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {

                    throw new MyArrayDataException("Неверные данные в ячейке: строка " + i + ", колонка " + j);
                }
            }
        }

        return totalSum;
    }

    // ЗАДАНИЕ 3
       public static void main(String[] args) {


        String[][] goodMatrix = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "1", "2", "3"},
                {"4", "5", "6", "7"}
        };


        String[][] badDataMatrix = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "1", "2", "3"},
                {"4", "5", "6", "7"}
        };


        try {
            System.out.println("Тестируем массив с неверными данными");
            int result = checkAndSum(goodMatrix);
            System.out.println("Результат общей суммы: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }


        try {
            System.out.println("Тестируем массив с неверными данными");
            int result = checkAndSum(badDataMatrix);
            System.out.println("Результат общей суммы: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }


        // ЗАДАНИЕ 4
                try {
            System.out.println("Тест ошибки выхода за границы");

            int[] smallArray = {10, 20, 30};
            int ghostNumber = smallArray[5];

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Ловлю ошибку: " + e);
        }
    }
}


class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}