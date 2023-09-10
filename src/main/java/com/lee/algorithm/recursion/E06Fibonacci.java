package com.lee.algorithm.recursion;

import java.util.Arrays;

/**
 * 多路递归 - 求斐波那契第n项
 *
 * @author LiJing
 * @version 1.0
 */
public class E06Fibonacci {

    /**
     * <h3>使用 Memoization(记忆法, 也称备忘录) 改进</h3>
     *
     * @param n 第 n 项
     * @return 第 n 项的值
     */
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }

    private static int f(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }

        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;

        return cache[n];
    }
}
