package lesson_7_junit_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {

    @Test
    void testTriangleArea() {
        assertEquals(10.0, TriangleArea.calculate(4, 5));
    }

    @Test
    void testInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.calculate(-3, 5));
    }
}