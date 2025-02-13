package com.lee.datastructure.hashtable.leetcode;

/**
 * @author LiJing
 * @date 2024-03-17
 */
public class Leetcode383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt1 = count(ransomNote);
        int[] cnt2 = count(magazine);
        for (int i = 0; i < cnt1.length; i++) {
            if (cnt1[i] > 0) {
                if (cnt1[i] > cnt2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] count(String str) {
        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abc", "acc"));
        System.out.println(canConstruct("abc", "accb"));
    }
}
