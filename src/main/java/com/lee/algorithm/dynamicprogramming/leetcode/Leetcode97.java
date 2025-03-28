package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * @description: 交错字符串
 * @date: 2025/3/28
 */
public class Leetcode97 {
    /*
        s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"

        dp[i][j] 表示 s1 的前 i 个元素和 s2 的前 j 个元素是否能交错组成 s3 的前 i+j 个元素

           0  1  2  3  4  5
        0  √
        1     ×  ×  ×  ×  ×
        2     √  √  √  √  ×
        3     √  √  ×  √  ×
        4     ×  √  √  √  √
        5     ×  ×  √  ×  √

     */

    // 降维
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int p = i + j - 1;
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(p)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
            }
        }
        return dp[n];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int p = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
            }
        }

        return dp[m][n];
    }
}
