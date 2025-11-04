package lesson_7_testing;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTest {

    @Test
    public void testTriangleArea() {
        assertEquals(TriangleArea.calculate(4, 5), 10.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidValues() {
        TriangleArea.calculate(-3, 5);
    }
}