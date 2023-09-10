package com.lee.algorithm.recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.lee.algorithm.recursion.E06Fibonacci.fibonacci;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiJing
 * @version 1.0
 */
public class TestE06Fibonacci {

    @Test
    @DisplayName("测试 递归求斐波那契第n项")
    public void test1() {
        assertEquals(1, fibonacci(2));
        assertEquals(2, fibonacci(3));
        assertEquals(3, fibonacci(4));
        assertEquals(5, fibonacci(5));
        assertEquals(8, fibonacci(6));
        assertEquals(13, fibonacci(7));
        assertEquals(21, fibonacci(8));
        assertEquals(34, fibonacci(9));
        assertEquals(55, fibonacci(10));
        assertEquals(89, fibonacci(11));
        assertEquals(144, fibonacci(12));
        assertEquals(233, fibonacci(13));
    }
}
