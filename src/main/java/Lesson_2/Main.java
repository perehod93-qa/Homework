package Lesson_2;

public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

        boolean result5 = checkSumInRange(12, 3);
        System.out.println(result5);

        printNumberSign(24);
        System.out.println(isNegative(-7));

        printStringMultipleTimes("I don't understand what's happening here", 3);

        boolean leap = isLeapYear(2024);
        System.out.println(leap);

        int[] binary = {1, 0, 1, 0, 1};
        invertArray(binary);
        printArray(binary);

        int[] from1To100 = fillArray1To100();
        printArray(from1To100);

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyLessThan6(arr);
        printArray(arr);

        int[][] matrix = createDiagonalMatrix(8);
        printMatrix(matrix);

        int[] customArray = createArrayWithValue(8, 35);
        printArray(customArray);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 9;
        int b = -16;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 120;

        if (value <= 0) {
            System.out.println("Красный");
        } else {
            if (value <= 100) {
                System.out.println("Желтый");
            } else {
                System.out.println("Зеленый");
            }
        }
    }

    public static void compareNumbers() {
        int a = 37;
        int b = 20;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSumInRange(int a, int b) {
        int sum = a + b;

        return sum >= 10 && sum <= 20;
    }

    public static void printNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printStringMultipleTimes(String text, int count) {
        int i = 0;

        while (i < count) {
            System.out.println(text);
            i++;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else {
            if (year % 100 != 0) {
                return true;
            } else {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static void invertArray(int[] array) {
        int i = 0;

        while (i < array.length) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }

            i++;
        }
    }

    public static int[] fillArray1To100() {
        int[] array = new int[100];
        int i = 0;

        while (i < 100) {
            array[i] = i + 1;
            i++;
        }

        return array;
    }

    public static void multiplyLessThan6(int[] array) {
        int i = 0;

        while (i < array.length) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }

            i++;
        }
    }

    public static int[][] createDiagonalMatrix(int size) {
        int[][] matrix = new int[size][size];
        int i = 0;

        while (i < size) {
            matrix[i][i] = 1;
            matrix[i][size - 1 - i] = 1;
            i++;
        }

        return matrix;
    }

    public static int[] createArrayWithValue(int len, int value) {
        int[] array = new int[len];
        int i = 0;

        while (i < len) {
            array[i] = value;
            i = i + 1;
        }

        return array;
    }

    // печать массива
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // печать матрицы
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
