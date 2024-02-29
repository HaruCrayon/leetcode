package com.lee.datastructure.string;

/**
 * 5. 最长回文子串
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode5 {
    private int left;
    private int right;

    public String longestPalindrome(String s) {
        left = 0;
        right = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            extend(chars, i, i); // 一个字符作为中心点
            extend(chars, i, i + 1); // 两个字符作为中心点
        }
        return new String(chars, left, right - left + 1);
    }

    private void extend(char[] chars, int i, int j) {
        // 如果是回文，扩大回文范围
        while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
            i--;
            j++;
        }
        // 退出循环时，i和j指向的不是回文，需要还原
        i++;
        j--;
        if (j - i > right - left) {
            left = i;
            right = j;
        }
    }

    public static void main(String[] args) {
        Leetcode5 obj = new Leetcode5();
        System.out.println(obj.longestPalindrome("babad"));
        System.out.println(obj.longestPalindrome("cbbd"));
        System.out.println(obj.longestPalindrome("a"));
        System.out.println(obj.longestPalindrome("bccbcbabcbafa"));
    }
}
