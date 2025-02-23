package com.lee.bitwise;

/**
 * @description: 位1的个数
 * @author: LiJing
 * @date: 2025/2/23
 */
public class Leetcode191 {

    // 方法1：逐位判断
    public int hammingWeight01(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += n & 1;
            n >>>= 1;
        }
        return cnt;
    }

    // 方法2：巧用 n&(n−1) 消去数字n最右边的1
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            // (n−1)：二进制数字n最右边的1变成0，此1右边的0都变成1
            // n&(n−1)：二进制数字n最右边的1变成0，其余不变
            n &= n - 1;
        }
        return cnt;
    }
}
