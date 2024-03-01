package com.lee.datastructure.string;

/**
 * 58. 最后一个单词的长度
 *
 * @author LiJing
 * @date 2024-03-01
 */
public class Leetcode58 {

    public static int lengthOfLastWord(String s) {
        int cnt = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            cnt++;
            i--;
        }
        return cnt;
    }

    public static int lengthOfLastWord2(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int j = i;
        while (j >= 0 && s.charAt(j) != ' ') {
            j--;
        }
        return i - j;
    }

    public static void main(String[] args) {
//        String s = "   fly me   to   the moon  ";
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
}
