package com.lee.algorithm.twopointers;

/**
 * 392. 判断子序列
 *
 * @author LiJing
 * @date 2024-03-03
 */
public class Leetcode392 {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
