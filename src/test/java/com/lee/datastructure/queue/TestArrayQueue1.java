package com.lee.datastructure.queue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayQueue1 {

    @Test
    public void generic() {
        ArrayQueue1<String> queue = new ArrayQueue1<>(3);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        assertFalse(queue.offer("d"));
        assertFalse(queue.offer("e"));

        assertIterableEquals(Arrays.asList("a", "b", "c"), queue);
    }

    @Test
    public void offerLimit() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertFalse(queue.offer(4));
        assertFalse(queue.offer(5));

        assertIterableEquals(Arrays.asList(1, 2, 3), queue);
    }

    @Test
    public void poll1() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        queue.offer(1);
        assertEquals(1, queue.poll());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void offer() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), queue);
    }

    @Test
    public void peek() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        assertNull(queue.peek());
        queue.offer(1);
        assertEquals(1, queue.peek());
        queue.offer(2);
        assertEquals(1, queue.peek());
    }

    @Test
    public void poll() {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertNull(queue.poll());

        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        assertIterableEquals(Arrays.asList(4, 5, 6), queue);
    }
}
