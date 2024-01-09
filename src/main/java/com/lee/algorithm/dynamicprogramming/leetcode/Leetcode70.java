package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * 70. 爬楼梯
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode70 {
    /*
        每次都要尝试走1步或走两步
            0       1      2      3      4      5
        1   1       1
        2           1      11
                           2
        3                         111
                                  12
                                  21
        4
                                         1111
                                         112
                                         121
                                         211
                                         22
        5                                       1111
                                                1112
                                                1121
                                                1211
                                                122
                                                2111
                                                212
                                                221
     */

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= 2; i++) {
                if (j >= i) {
                    dp[j] = dp[j] + dp[j - i];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode70 obj = new Leetcode70();
        System.out.println(obj.climbStairs(5)); // 8
        System.out.println(obj.climbStairs(3)); // 3
    }
}
