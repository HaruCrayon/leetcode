package com.lee.algorithm.recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.lee.algorithm.recursion.E04BubbleSort.sort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author LiJing
 * @version 1.0
 */
public class TestE04BubbleSort {

    @Test
    @DisplayName("测试 递归冒泡排序")
    public void test1() {
        int[] expected = {1, 2, 3, 4, 5};

        int[] a1 = {5, 4, 3, 2, 1};
        sort(a1);
        assertArrayEquals(expected, a1);

        int[] a2 = {4, 5, 3, 2, 1};
        sort(a2);
        assertArrayEquals(expected, a2);

        int[] a3 = {3, 1, 4, 2, 5};
        sort(a3);
        assertArrayEquals(expected, a3);

        int[] a4 = {1, 2, 3, 4, 5};
        sort(a4);
        assertArrayEquals(expected, a4);
    }
}
