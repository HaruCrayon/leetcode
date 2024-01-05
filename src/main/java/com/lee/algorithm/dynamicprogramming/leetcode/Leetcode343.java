package com.lee.algorithm.dynamicprogramming.leetcode;

import java.util.Arrays;

/**
 * 343. 整数拆分
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode343 {
    /*
        0   1    2    3      4

     1  1  1+0  1+1  1+1+1  1+1+1+1

     2  1  1+0  1+1  1+1+1  1+1+1+1
                2+0  2+1    2+1+1
                            2+2

     3  1  1+0  1+1  1+1+1  1+1+1+1
                2+0  2+1    2+1+1
                     3+0    2+2
                            3+1

     4  1  1+0  1+1  1+1+1  1+1+1+1
                2+0  2+1    2+1+1
                     3+0    2+2
                            3+1
                            4+0

     */

    // 降维
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n + 1; j++) {
                dp[j] = Integer.max(dp[j], i * dp[j - i]);
            }
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        int[][] dp = new int[n][n + 1];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n + 1; j++) {
                if (j >= i) {
                    dp[i][j] = Integer.max(dp[i - 1][j], i * dp[i][j - i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][n];
    }

    public static void main(String[] args) {
        Leetcode343 obj = new Leetcode343();
        System.out.println(obj.integerBreak(10));
    }
}
