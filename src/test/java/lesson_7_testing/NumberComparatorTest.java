package lesson_7_testing;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTest {

    @Test
    public void testFirstGreater() {
        assertEquals(NumberComparator.compare(5, 3), "Первое число больше");
    }

    @Test
    public void testSecondGreater() {
        assertEquals(NumberComparator.compare(2, 4), "Второе число больше");
    }

    @Test
    public void testEqual() {
        assertEquals(NumberComparator.compare(5, 5), "Числа равны");
    }
}