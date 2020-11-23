package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testPeekMethod() {
        Queue queue = new Queue();
        queue.enqueue("aa");
        queue.enqueue("bb");

        String expectedResult = "aa";
        Object actualResult = queue.peek();

        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testPeekMethodOfEmptyQueue() {
        Queue queue = new Queue();
        Object actualResult = queue.peek();

        assertNull(actualResult);
    }

    @Test
    public void testDequeueMethod() {
        Queue queue = new Queue();
        queue.enqueue("aa");
        queue.enqueue("bb");
        queue.enqueue("cc");

        String expectedResult = "aa";
        Object actualResult = queue.dequeue();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDequeueMethodOfEmptyList() {
        Queue queue = new Queue();
        Object actualResult = queue.dequeue();

        assertNull(actualResult);
    }
}
