package com.lee.bitwise;

/**
 * @description: 数字范围按位与
 * @author: LiJing
 * @date: 2025/2/23
 */
public class Leetcode201 {
    /*
        给定两个整数，找到它们对应的二进制字符串的公共前缀
        m=9   00001001
        n=12  00001100
     */

    // 方法1：位移
    public int rangeBitwiseAnd01(int left, int right) {
        int shift = 0;
        // 通过右移，将两个数字压缩为它们的公共前缀。在迭代过程中，计算执行的右移操作数。
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // 将得到的公共前缀左移相同的操作数得到结果。
        return left << shift;
    }

    // 方法2：Brian Kernighan 算法
    // n&(n−1) 消去 数字n对应二进制串 最右边的1
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= right - 1;
        }
        return right;
    }
}
