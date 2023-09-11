package com.lee.algorithm.recursion;

import java.util.LinkedList;

/**
 * 多路递归 - 汉诺塔
 *
 * @author LiJing
 * @version 1.0
 */
public class E07HanoiTower {
    private static LinkedList<Integer> a = new LinkedList<>();
    private static LinkedList<Integer> b = new LinkedList<>();
    private static LinkedList<Integer> c = new LinkedList<>();

    public static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    /**
     * <h3>移动圆盘</h3>
     *
     * @param n 圆盘个数
     * @param a 由
     * @param b 借
     * @param c 至
     */
    public static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        move(n - 1, a, c, b); // 把 n-1 个盘子由a,借c,移至b
        c.addLast(a.removeLast()); // 把最后的盘子由 a 移至 c
        print();
        move(n - 1, b, a, c); // 把 n-1 个盘子由b,借a,移至c
    }

    // T(n) = 2T(n-1) + c, T(1) = c
    // T(n) = c(2^n - 1)
    // 时间复杂度 O(2^n)

    private static void print() {
        System.out.println("----------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void main(String[] args) {
        init(4);
        print();
        move(4, a, b, c);
    }
}
