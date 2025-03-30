package com.lee.math;

/**
 * @description: 回文数
 * @author: LiJing
 * @date: 2025/2/28
 */
public class Leetcode9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x, cur = 0;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return x == cur;
    }
}
