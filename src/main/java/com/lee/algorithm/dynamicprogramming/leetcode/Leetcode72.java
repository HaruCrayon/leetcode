package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * @description: 编辑距离
 * @date: 2025/3/28
 */
public class Leetcode72 {
    /*
        word1 = "horse", word2 = "ros"

        dp[i][j] 表示 word1 前i个字符 转换成 word2 前j个字符需要最少步数

        替换:  dp[i][j] = dp[i-1][j-1] + 1
        删除:  dp[i][j] = dp[i-1][j] + 1
        插入:  dp[i][j] = dp[i][j-1] + 1

           ''  r  o  s
       ''  0   1  2  3
        h  1
        o  2
        r  3
        s  4
        e  5

     */

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // 有一个字符串为空串
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        // 边界状态初始化
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
