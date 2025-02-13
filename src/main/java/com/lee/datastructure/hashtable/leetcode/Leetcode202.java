package com.lee.datastructure.hashtable.leetcode;

import java.util.HashSet;

/**
 * @description: 快乐数
 * @author: LiJing
 * @date: 2025/2/13
 */
public class Leetcode202 {

    // 1. 做数位分离，求平方和。
    // 2. 每次生成链中的下一个数字时，检查它是否已经在哈希集合中。

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
}
