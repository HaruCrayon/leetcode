package com.lee.algorithm.recursion;

/**
 * 递归 - 求阶乘
 *
 * @author LiJing
 * @version 1.0
 */
public class E01Factorial {

    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        int f = f(5);
        System.out.println(f);
    }
}
