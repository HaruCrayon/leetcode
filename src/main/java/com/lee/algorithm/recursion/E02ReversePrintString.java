package com.lee.algorithm.recursion;

/**
 * 递归 - 反向打印字符串
 *
 * @author LiJing
 * @version 1.0
 */
public class E02ReversePrintString {

    public static void f(int n, String str) {
        if (n == str.length()) {
            return;
        }
        f(n + 1, str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        f(0, "abcd");
    }
}
