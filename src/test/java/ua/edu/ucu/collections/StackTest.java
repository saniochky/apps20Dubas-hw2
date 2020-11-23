package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPeekMethod() {
        Stack stack = new Stack();
        stack.push("aa");
        stack.push("bb");

        String expectedResult = "bb";
        Object actualResult = stack.peek();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPeekMethodOfEmptyStack() {
        Stack stack = new Stack();
        Object actualResult = stack.peek();

        assertNull(actualResult);
    }

    @Test
    public void testDequeueMethod() {
        Stack stack = new Stack();
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");

        String expectedResult = "cc";
        Object actualResult = stack.pop();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDequeueMethodOfEmptyList() {
        Stack stack = new Stack();
        Object actualResult = stack.pop();

        assertNull(actualResult);
    }
}
