package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * @description: 最大正方形
 * @date: 2025/3/28
 */
public class Leetcode221 {
    /*
        dp[i][j] 表示以 (i,j) 为右下角，且只包含 1 的正方形的边长最大值

     */

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
