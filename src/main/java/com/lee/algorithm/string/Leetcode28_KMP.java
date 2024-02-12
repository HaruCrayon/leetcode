package com.lee.algorithm.string;

/**
 * <h3>字符串匹配 - KMP算法 The Knuth-Morris-Pratt Algorithm</h3>
 * <p>28. 找出字符串中第一个匹配项的下标</p>
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode28_KMP {

    public static int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray(); // 原始串
        char[] pattern = needle.toCharArray(); // 模式串
        int[] lps = lps(pattern); // 最长前后缀数组
        /*
            1. 匹配成功，i++ j++，直到 j==模式字符串长度
            2. 匹配失败
                j != 0 跳过最长前后缀字符，继续匹配
                j == 0 则 i++
         */
        int i = 0;
        int j = 0;
        while (pattern.length - j <= origin.length - i) {
            if (origin[i] == pattern[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j - 1];
            }
            if (j == pattern.length) { // 找到解
                return i - j;
            }
        }
        return -1;
    }

    /*
        longest prefix suffix 最长前后缀数组：只跟模式字符串相关
        1. 索引：使用了模式字符串前 j 个字符串 - 1
        2. 值：最长前后缀的长度（恰好是j要跳转的位置）
     */
    private static int[] lps(char[] pattern) {
        int[] lps = new int[pattern.length];
        /*
            遇到相同字符：记录共同前后缀长度。长度即为 j+1，长度记录至数组 i 索引处。i++  j++
            遇到不同字符：
                前面没有共同部分(j==0)：i++
                前面有共同部分：j 向回找。无需对比的地方，可以跳过；无需对比的字符个数，之前已计算过
         */
        int i = 1;
        int j = 0;
        while (i < pattern.length) {
            if (pattern[i] == pattern[j]) {
                lps[i] = j + 1;
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j - 1];
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(strStr("ababababcabacacababaca", "ababaca"));
//        System.out.println("ababababcabacacababaca".indexOf("ababaca"));
    }
}
