package com.lee.algorithm.dynamicprogramming.leetcode;

import java.util.List;

/**
 * @description: 三角形最小路径和
 * @date: 2025/3/24
 */
public class Leetcode120 {

    // 降维
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Integer.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int minTotal = dp[0];
        for (int i = 0; i < n; i++) {
            minTotal = Integer.min(minTotal, dp[i]);
        }
        return minTotal;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int curr = i % 2, prev = 1 - curr;
            dp[curr][0] = dp[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[curr][j] = Integer.min(dp[prev][j], dp[prev][j - 1]) + triangle.get(i).get(j);
            }
            dp[curr][i] = dp[prev][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[(n - 1) % 2][0];
        for (int i = 1; i < n; i++) {
            minTotal = Integer.min(minTotal, dp[(n - 1) % 2][i]);
        }
        return minTotal;
    }
}
