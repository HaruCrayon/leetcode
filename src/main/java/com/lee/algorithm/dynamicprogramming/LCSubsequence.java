package com.lee.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

/**
 * <h3>最长公共子序列</h3>
 */
public class LCSubsequence {
    /*
              a  b  c  x  y  z
           0  0  0  0  0  0  0
        a  0  1  1  1  1  1  1
        b  0  1  2  2  2  2  2
        x  0  1  2  2  3  3  3
        y  0  1  2  2  3  4  4
        z  0  1  2  2  3  4  5

        相同字符
            找到上一行上一列数值+1
        不同字符
            max(上一行, 上一列)
     */

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
        print(dp, text2, text1);
        return dp[m][n];
    }

    private static void print(int[][] dp, String a, String b) {
        System.out.println(String.join("", Collections.nCopies(23, "-")));
        Object[] array = a.chars().mapToObj(i -> String.valueOf((char) i)).toArray();
        System.out.printf("     " + String.join("", Collections.nCopies(a.length(), "%2s ")) + "%n", array);
        System.out.printf("     " + String.join("", Collections.nCopies(a.length(), "%2s ")) + "%n", a.chars().mapToObj(i -> "0").toArray());
        for (int i = 0; i < b.length(); i++) {
            int[] d = dp[i + 1];
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(b.charAt(i) + " " + String.join("", Collections.nCopies(d.length, "%2d ")) + "%n", array);
        }
    }

    public static void main(String[] args) {
        LCSubsequence code = new LCSubsequence();
        System.out.println(code.longestCommonSubsequence("abxyz", "abcxyz")); // 5
        System.out.println(code.longestCommonSubsequence("ba", "yby")); // 1
    }
}
