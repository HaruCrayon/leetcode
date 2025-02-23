package com.lee.bitwise;

/**
 * @description: 只出现一次的数字 II
 * @author: LiJing
 * @date: 2025/2/23
 */
public class Leetcode137 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            // 使用位运算 (num >> i) & 1 得到 num 的第i个二进制位
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            // 答案的第i个二进制位就是数组中所有元素的第i个二进制位之和除以3的余数
            if (total % 3 == 1) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
