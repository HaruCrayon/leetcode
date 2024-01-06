package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * 583. 两个字符串的删除操作
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode583 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            char x = chars1[i - 1];
            for (int j = 1; j < n + 1; j++) {
                char y = chars2[j - 1];
                if (x == y) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        Leetcode583 obj = new Leetcode583();
        System.out.println(obj.minDistance("sea", "eat")); // 2
        System.out.println(obj.minDistance("leetcode", "etco")); // 4
        System.out.println(obj.minDistance("park", "spake")); // 3
    }
}
