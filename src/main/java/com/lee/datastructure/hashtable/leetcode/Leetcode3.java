package com.lee.datastructure.hashtable.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode3 {
    /*
        给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
        s 由英文字母、数字、符号和空格组成

        [(a,3) (b,1) (c,2)]

         b
           e
        abcabcbb
        思路：
            1.用 begin 和 end 表示子串开始和结束位置
            2.用 hash 表检查重复字符
            3.从左向右查看每个字符, 如果:
             - 没遇到重复字符，调整 end
             - 遇到重复的字符，调整 begin
             - 将当前字符放入 hash 表
            4.end - begin + 1 是当前子串长度
     */

    public int lengthOfLongestSubstring01(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                begin = Math.max(begin, map.get(ch) + 1);
                map.put(ch, end);
            } else {
                map.put(ch, end);
            }
//            System.out.println(s.substring(begin, end + 1));
            maxLength = Math.max(maxLength, end - begin + 1);
        }
        return maxLength;
    }

    // 优化
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        Arrays.fill(map, -1);
        int begin = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map[ch] != -1) {
                begin = Math.max(begin, map[ch] + 1);
                map[ch] = end;
            } else {
                map[ch] = end;
            }
            System.out.println(s.substring(begin, end + 1));
            maxLength = Math.max(maxLength, end - begin + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        String s = "abcabcbb";
//        String s = "abba";
        System.out.println(leetcode3.lengthOfLongestSubstring(s));
    }
}
