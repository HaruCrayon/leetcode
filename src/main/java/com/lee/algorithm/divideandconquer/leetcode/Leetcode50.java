package com.lee.algorithm.divideandconquer.leetcode;

/**
 * 50. Pow(x, n)
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode50 {
    /*

                           2^16                 65536  乘四次
                   /                  \
                 2^8                  2^8        256*256  乘三次
              /      \              /      \
             2^4     2^4           2^4     2^4    16*16  乘二次
            /  \     /  \         /  \     /  \
          2^2 2^2  2^2 2^2       2^2 2^2  2^2 2^2   4*4  乘一次
          /\  /\   /\  /\       /\  /\    /\  /\
         2 2 2 2  2 2 2 2      2 2 2 2   2 2 2  2


                  2^10
              /         \
            2^5         2^5    2*2^4
           /  \        /  \
        2 2^2 2^2    2 2^2 2^2
         / \  / \     / \  / \
        2  2  2  2   2  2  2  2

     */

    public double myPow(double x, int n) {
        long p = n;
        if (p < 0) {
            p = -p;
        }
        double r = myPowPositive(x, p);
        return n < 0 ? 1 / r : r;
    }

    private double myPowPositive(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        double y = myPowPositive(x, n / 2);
        if ((n & 1) == 0) { // 偶数
            return y * y;
        } else { // 奇数
            return x * y * y;
        }
    }

    public static void main(String[] args) {
        Leetcode50 obj = new Leetcode50();
        System.out.println(obj.myPow(2, 16));  // 65536.0
        System.out.println(obj.myPow(2, 10));  // 1024.0
        System.out.println(obj.myPow(2, 0)); // 1.0
        System.out.println(obj.myPow(2, -2)); // 0.25    2^-2 = 1/2^2
        System.out.println(obj.myPow(2, -2147483648)); // 0.0
        System.out.println(obj.myPow(2.1, 3)); // 9.261
    }
}
