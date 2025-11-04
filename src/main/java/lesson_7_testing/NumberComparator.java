package lesson_7_testing;

public class NumberComparator {
    public static String compare(int a, int b) {
        if (a > b) return "Первое число больше";
        if (a < b) return "Второе число больше";
        return "Числа равны";
    }
}