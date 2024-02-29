package com.lee.datastructure.array.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 *
 * @author LiJing
 * @date 2024-02-29
 */
public class Leetcode13 {
    /*
        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
     */

    private final static Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int val = map.get(chars[i]);
            if (i < n - 1 && val < map.get(chars[i + 1])) {
                sum -= val;
            } else {
                sum += val;
            }
        }
        return sum;
    }
}
