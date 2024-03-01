package com.lee.datastructure.string;

/**
 * 151. 反转字符串中的单词
 *
 * @author LiJing
 * @date 2024-03-02
 */
public class Leetcode151 {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) {
                sb.delete(sb.lastIndexOf(" "), sb.lastIndexOf(" ") + 1);
                break;
            }
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            sb.append(s.substring(j + 1, i + 1));
            if (j >= 0) {
                sb.append(" ");
            }
            i = j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "the sky is blue";
//        String s = "  hello world  ";
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
