package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * 96. 不同的二叉搜索树
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int j = 2; j < n + 1; j++) {
            for (int i = 0; i < j; i++) {
                dp[j] += dp[i] * dp[j - 1 - i];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode96 obj = new Leetcode96();
        System.out.println(obj.numTrees(3));
        System.out.println(obj.numTrees(1));
        System.out.println(obj.numTrees(6));
    }
}
