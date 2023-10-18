package com.lee.datastructure.hashtable.leetcode;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode387 {
    /*
        给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
        s 只包含小写字母
     */

    public int firstUniqChar(String s) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            array[ch - 97]++;
        }
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (array[ch - 97] == 1) {
                return i;
            }
        }
        return -1;
    }
}
