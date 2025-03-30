package com.lee.math;

/**
 * @description: 阶乘后的零
 * @author: LiJing
 * @date: 2025/2/28
 */
public class Leetcode172 {
    /*
        n! = 1 * 2 * 3 * 4 * (1 * 5) * ... * (2 * 5) * ... * (3 * 5) *... * n

        n! = ... * (1 * 5) * ... * (1 * 5 * 5) * ... * (2 * 5 * 5) * ... * (3 * 5 * 5) * ... * n

        1.规律就是每隔 5 个数，出现一个 5，每隔 25 个数，出现 2 个 5，每隔 125 个数，出现 3 个 5... 以此类推。
          最终 5 的个数就是 n / 5 + n / 25 + n / 125 ...
        2.写程序时，如果直接按照上边的式子计算，分母可能会造成溢出。
          所以算 n / 25 时，先把 n 更新，n = n / 5，然后再计算 n / 5
     */

    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }
}
