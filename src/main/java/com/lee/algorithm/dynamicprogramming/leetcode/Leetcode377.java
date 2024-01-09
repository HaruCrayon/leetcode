package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * 377. 组合总和 Ⅳ
 * <p>类似于零钱兑换518题 区别在于零钱兑换求的是组合数，本题求的是排列数</p>
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode377 {
    /*
            0       1       2       3       4 总金额
        1           1       11      111     1111
        2           1       11      111     1111
                            2       12      112
                                    21      121
                                            22
                                            211
        3           1       11      111     1111
                            2       12      112
                                    21      121
                                    3       13
                                            211
                                            22
                                            31
        面值
        dp[j] = dp[j-1] + dp[j-2] + dp[j-3]
     */

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j < target + 1; j++) {
            for (int num : nums) {
                if (j >= num) {
                    dp[j] = dp[j] + dp[j - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Leetcode377 obj = new Leetcode377();
        System.out.println(obj.combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
