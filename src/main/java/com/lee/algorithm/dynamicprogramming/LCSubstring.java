package com.lee.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

/**
 * <h3>最长公共子串</h3>
 */
public class LCSubstring {
    /*
            i   t   h   e   i   m   a
        t   0   1   0   0   0   0   0
        h   0   0   2   0   0   0   0
        e   0   0   0   3   0   0   0
        m   0   0   0   0   0   1   0
        a   0   0   0   0   0   0   2

        if(相同字符) {
            dp[i][j] = dp[i-1][j-1] + 1
        } else {
            dp[i][j] = 0
        }
     */

    static int lcs(String a, String b) {
        int[][] dp = new int[b.length()][a.length()];
        int max = 0;
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == b.charAt(i)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Integer.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        print(dp, a, b);
        return max;
    }

    private static void print(int[][] dp, String a, String b) {
        System.out.println(String.join("", Collections.nCopies(23, "-")));
        Object[] array = a.chars().mapToObj(i -> String.valueOf((char) i)).toArray();
        System.out.printf("  " + String.join("", Collections.nCopies(a.length(), "%2s ")) + "%n", array);
        for (int i = 0; i < b.length(); i++) {
            int[] d = dp[i];
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(b.charAt(i) + " " + String.join("", Collections.nCopies(d.length, "%2d ")) + "%n", array);
        }
    }

    public static void main(String[] args) {
        System.out.println(lcs("itheima", "thema"));
    }
}
