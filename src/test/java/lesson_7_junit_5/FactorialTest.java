package lesson_7_junit_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }

    @Test
    void testFactorialOf5() {
        assertEquals(120L, factorial.calculate(5));
    }

    @Test
    void testFactorialOf0() {
        assertEquals(1L, factorial.calculate(0));
    }

    @Test
    void testNegativeNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> factorial.calculate(-3)
        );
        assertEquals("Число не может быть отрицательным", exception.getMessage());
    }
}