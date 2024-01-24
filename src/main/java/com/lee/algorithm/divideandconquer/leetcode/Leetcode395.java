package com.lee.algorithm.divideandconquer.leetcode;

/**
 * 395. 至少有 K 个重复字符的最长子串
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode395 {
    /*
        s = "dddxaabaaabaacciiiiefbff"      k = 3

            ddd aabaaabaa iiii fbff
                aa aaa aa      f ff

            统计字符串中每个字符的出现次数，移除那些出现次数 < k 的字符
            剩余的子串，递归做此处理，直至
                 - 整个子串长度 < k (该子串排除/落选)
                 - 子串中没有出现次数 < k 的字符 (该子串入选)
     */

    public int longestSubstring(String s, int k) {
        // 子串落选
        if (s.length() < k) {
            return 0;
        }
        int[] counts = new int[26]; // 索引对应字符, 值表示该字符出现了几次
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counts[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int count = counts[c - 'a'];
            if (count > 0 && count < k) {
                int j = i + 1;
                while (j < s.length() && counts[chars[j] - 'a'] < k) {
                    j++;
                }
                return Integer.max(longestSubstring(s.substring(0, i), k),
                        longestSubstring(s.substring(j), k));
            }
        }
        // 子串入选
        return s.length();
    }

    public static void main(String[] args) {
        Leetcode395 obj = new Leetcode395();
        System.out.println(obj.longestSubstring("aaabb", 3)); // 3
        System.out.println(obj.longestSubstring("ababbc", 2)); // 5
        System.out.println(obj.longestSubstring("ababbc", 3)); // 0
        System.out.println(obj.longestSubstring("dddxaabaaabaacciiiiefbff", 3)); // 4
    }
}
