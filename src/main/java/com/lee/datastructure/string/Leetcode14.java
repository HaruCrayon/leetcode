package com.lee.datastructure.string;

/**
 * 14. 最长公共前缀
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode14 {

    /*
               i
         j   f l o w e r
             f l o w
             f l i g h t
     */

    public static String longestCommonPrefix(String[] strs) {
        /*
            情况1：比较某一列时，遇到不同字符，i 之前的字符就是解
            情况2：比较某一列时，遇到字符串长度不够，i 之前的字符就是解
            情况3：i 循环自然结束，此时第一个字符串就是解
         */
        char[] first = strs[0].toCharArray(); // 第一个字符串
        for (int i = 0; i < first.length; i++) {
            char ch = first[i];
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || ch != strs[j].charAt(i)) {
                    return new String(first, 0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"})); // 空串
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"})); // a
        System.out.println(longestCommonPrefix(new String[]{"dog", "dogaa", "dogbb"})); // dog
    }
}
