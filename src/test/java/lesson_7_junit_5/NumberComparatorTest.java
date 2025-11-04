package lesson_7_junit_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {

    @Test
    void testFirstGreater() {
        assertEquals("Первое число больше", NumberComparator.compare(5, 3));
    }

    @Test
    void testSecondGreater() {
        assertEquals("Второе число больше", NumberComparator.compare(2, 4));
    }

    @Test
    void testEqual() {
        assertEquals("Числа равны", NumberComparator.compare(5, 5));
    }
}