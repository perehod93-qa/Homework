package lesson_7_testing;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        assertEquals(Calculator.add(3, 4), 7);
    }

    @Test
    public void testSubtract() {
        assertEquals(Calculator.subtract(5, 4), 1);
    }

    @Test
    public void testMultiply() {
        assertEquals(Calculator.multiply(3, 4), 12);
    }

    @Test
    public void testDivide() {
        assertEquals(Calculator.divide(8, 4), 2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator.divide(5, 0);
    }
}