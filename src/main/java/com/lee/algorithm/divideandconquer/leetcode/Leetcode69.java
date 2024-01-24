package com.lee.algorithm.divideandconquer.leetcode;

/**
 * 69. x 的平方根
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode69 {
    /*
        99 = 9.?

        1*1 = 1  10 次
        2*2 = 4
        ...
        9*9 = 81
        10*10 = 100


        x=99

        i j  m
        1 99 50  6 次
        1 49 25
        1 24 12
        1 11 6
        7 11 9
        10 11 10
     */

    public int mySqrt(int x) {
        int i = 1, j = x;
        int r = 0;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (m <= x / m) {
                i = m + 1;
                r = m;
            } else {
                j = m - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Leetcode69 obj = new Leetcode69();
        System.out.println(obj.mySqrt(99));
        System.out.println(obj.mySqrt(1));
        System.out.println(obj.mySqrt(2));
        System.out.println(obj.mySqrt(4));
        System.out.println(obj.mySqrt(5));
        System.out.println(obj.mySqrt(8));
        System.out.println(obj.mySqrt(9));
        System.out.println(obj.mySqrt(2147395599));
    }
}
