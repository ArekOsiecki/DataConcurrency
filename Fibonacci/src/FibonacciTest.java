import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testIterativeF() {
        int expected = 3;
        int actual = Fibonacci.iterativeF(4);

        assertEquals(expected, actual);
    }

    @Test
    void testRecursiveF() {
        int expected = 8;
        int actual = Fibonacci.recursiveF(6);
        assertEquals(expected, actual);
    }
}