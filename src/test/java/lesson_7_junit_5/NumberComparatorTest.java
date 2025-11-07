package lesson_7_junit_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberComparatorTest {

    private NumberComparator comparator;

    @BeforeEach
    void setUp() {
        comparator = new NumberComparator();
    }

    @Test
    void testFirstGreater() {
        assertEquals("Первое число больше", comparator.compare(5, 3));
    }

    @Test
    void testSecondGreater() {
        assertEquals("Второе число больше", comparator.compare(2, 4));
    }

    @Test
    void testEqual() {
        assertEquals("Числа равны", comparator.compare(5, 5));
    }
}