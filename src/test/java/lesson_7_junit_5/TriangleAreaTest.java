package lesson_7_junit_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleAreaTest {

    private TriangleArea triangleArea;

    @BeforeEach
    void setUp() {
        triangleArea = new TriangleArea();
    }

    @Test
    void testTriangleAreaValid() {
        assertEquals(10.0, triangleArea.calculate(4.0, 5.0));
    }

    @Test
    void testInvalidValuesThrows() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> triangleArea.calculate(-3.0, 5.0)
        );
        assertEquals("Основание и высота должны быть положительными", exception.getMessage());
    }
}