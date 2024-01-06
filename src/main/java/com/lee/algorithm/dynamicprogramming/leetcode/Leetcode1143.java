package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * 1143. 最长公共子序列
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
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
        return dp[m][n];
    }

    public static void main(String[] args) {
        Leetcode1143 obj = new Leetcode1143();
        System.out.println(obj.longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println(obj.longestCommonSubsequence("abc", "def")); // 0
    }
}
