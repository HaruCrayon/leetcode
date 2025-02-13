package com.lee.datastructure.hashtable.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 单词规律
 * @author: LiJing
 * @date: 2025/2/13
 */
public class Leetcode290 {
    // pattern = "abba", s = "dog cat cat fish"

    public static boolean wordPattern(String pattern, String s) {
        String[] strArr = s.split(" ");
        if (pattern.length() != strArr.length) {
            return false;
        }
        List<String> strList = Arrays.asList(strArr);
        for (int i = 0; i < pattern.length(); i++) {
            // 比较同一索引的元素第一次出现的位置是否相同
            if (pattern.indexOf(pattern.charAt(i)) != strList.indexOf(strArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abbe", "dog cat cat dog"));
    }
}
