package lesson_7_junit_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void testAdd() {
        assertEquals(7, Calculator.add(3, 4));
    }

    @Test
    void testSubtract() {
        assertEquals(1, Calculator.subtract(5, 4));
    }

    @Test
    void testMultiply() {
        assertEquals(12, Calculator.multiply(3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, Calculator.divide(8, 4));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
    }
}