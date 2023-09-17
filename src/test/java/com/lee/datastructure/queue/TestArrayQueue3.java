package com.lee.datastructure.queue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayQueue3 {

    /*@Test
    public void constructor() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayQueue3<>(3));
    }*/

    @Test
    public void generic() {
        ArrayQueue3<String> queue = new ArrayQueue3<>(4);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        assertFalse(queue.offer("e"));

        assertIterableEquals(Arrays.asList("a", "b", "c", "d"), queue);
    }

    @Test
    public void offerLimit() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(4);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        assertFalse(queue.offer(5));

        assertIterableEquals(Arrays.asList(1, 2, 3, 4), queue);
    }

    @Test
    public void poll1() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(8);
        queue.offer(1);
        assertEquals(1, queue.poll());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void offer() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(8);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), queue);
    }

    @Test
    public void peek() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(8);
        assertNull(queue.peek());
        queue.offer(1);
        assertEquals(1, queue.peek());
        queue.offer(2);
        assertEquals(1, queue.peek());
    }

    @Test
    public void poll() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(8);
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

    @Test
    public void boundary() {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(16);
        //           2147483647 正整数的最大值 int
        queue.head = 2147483640;
        queue.tail = queue.head;

        for (int i = 0; i < 16; i++) {
//            System.out.println(queue.tail + " " + Integer.toUnsignedLong(queue.tail) + " " + Integer.toUnsignedLong(queue.tail) % 16);
//            queue.tail++;
            queue.offer(i);
        }

        assertIterableEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), queue);
    }

    @Test
    public void test1() {
        int head = 2147483640;
        int tail = 2147483647;
        /*tail += 5;
        System.out.println(tail);
        System.out.println(tail - head);*/

        // 验证 tail - head 不会有问题
        System.out.println(Integer.MAX_VALUE);
        // tail 已经自增为负数
        head = 1_900_000_000;
        tail = 2_100_000_000;
        for (int i = 0; i < 20; i++) {
            tail += 100_000_000;
            System.out.println(Integer.toUnsignedLong(tail) + " " + Integer.toUnsignedLong(head) + " " + (tail - head));
        }
        // 最后一次显示负数是因为 tail-head 4100000000-1900000000=2200000000 也超过了正整数最大值,而实际这种情况不可能发生(数组最大长度为正整数最大值)

        // tail 和 tail 都成了负数
        System.out.println("===========================");
        head = -2094967296; // 2200000000
        tail = -2094967296; // 2200000000
        for (int i = 0; i < 20; i++) {
            tail += 100_000_000;
            System.out.println(Integer.toUnsignedLong(tail) + " " + Integer.toUnsignedLong(head) + " " + (tail - head));
        }
    }

    @Test
    public void test2() {
        // 求离c最近，比c大的 2^n (方法1)
        int c = 30;

        /*
            2^4     = 16
            2^4.?   = 30
            2^5     = 32

              (int)log2(30) + 1
            2

            log2(x) = log10(x) / log10(2)

            1
            10      2^1
            100     2^2
            1000    2^3
         */

        /*int n = (int) (Math.log10(c - 1) / Math.log10(2)) + 1;
        System.out.println(n);
        System.out.println(1 << n);*/

        // 求离c最近，比c大的 2^n (方法2)
        c--;
        c |= c >> 1;
        c |= c >> 2;
        c |= c >> 4;
        c |= c >> 8;
        c |= c >> 16;
        c++;
        System.out.println(c);
    }
}
