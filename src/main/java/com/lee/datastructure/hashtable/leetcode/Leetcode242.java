package com.lee.datastructure.hashtable.leetcode;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode242 {

    /*
        s 和 t 仅包含小写字母

        输入: s = "anagram", t = "nagaram"
        输出: true

        解法1. 拿到字符数组，排序后比较字符数组
        解法2. 字符打散放入 int[26]，比较数组
         a                 g                 m  n           r
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

     */

    // 解法2
    public boolean isAnagram01(String s, String t) {
        return Arrays.equals(getKey01(s), getKey01(t));
    }

    private int[] getKey01(String s) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            array[ch - 97]++;
        }
        return array;
    }

    // 解法1
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(getKey(s), getKey(t));
    }

    private char[] getKey(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return chars;
    }
}
