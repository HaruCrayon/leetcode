package com.lee.math;

/**
 * 2427. 公因子的数目
 *
 * @author LiJing
 * @date 2024-02-23
 */
public class Leetcode2427 {

    public static int commonFactors(int a, int b) {
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        int count;
        if (a == b && a == 1) {
            count = 1;
        } else {
            count = m % n == 0 ? 2 : 1;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (m % i == 0 && n % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(commonFactors(12, 6)); // 4
        System.out.println(commonFactors(25, 30)); // 2
        System.out.println(commonFactors(1, 1)); // 1
        System.out.println(commonFactors(2, 2)); // 2
    }
}
