package com.lee.bitwise;

/**
 * @description: 颠倒二进制位
 * @author: LiJing
 * @date: 2025/2/22
 */
public class Leetcode190 {

    public int reverseBits(int n) {
        int rev = 0;
        // 迭代32次 或 n为0则提前结束
        for (int i = 0; i < 32 && n != 0; i++) {
            // (n&1): 用于获取n的最右边一位的值
            // << (31-i): 用于将结果移动到第(31-i)位上，从31,30,...0位
            // |=: 用于将计算出的值与当前rev值 按位或 运算
            rev |= (n & 1) << (31 - i);
            // >>> 无符号右移：向右移动，高位补0
            n >>>= 1;
        }
        return rev;
    }
}
