package com.lee.datastructure.hashtable.leetcode;

import java.util.HashMap;

/**
 * @author LiJing
 * @date 2024-03-17
 */
public class Leetcode205 {

    // s = "paper"
    // t = "title"

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (s2t.containsKey(ch1) && s2t.get(ch1) != ch2 ||
                    t2s.containsKey(ch2) && t2s.get(ch2) != ch1) {
                return false;
            }
            s2t.put(ch1, ch2);
            t2s.put(ch2, ch1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("fos", "baa"));
    }
}
