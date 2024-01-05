package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * 518. 零钱兑换 II
 * <p>可以凑成总金额的硬币组合数</p>
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode518 {
    /*
     面值    0      1      2      3      4      5         总金额-背包容量
     1      1      1      11     111    1111   11111

     2      1      1      11     111    1111   11111
                          2      21     211    2111
                                        22     221

     5      1      1      11     111    1111   11111
                          2      21     211    2111
                                        22     221
                                               5

     if(放得下)
        dp[i][j] = dp[i-1][j] + dp[i][j-coin]
     else(放不下)
        dp[i][j] = dp[i-1][j]

     */

    // 降维
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = coins[0]; j < amount + 1; j++) {
            dp[0][j] = dp[0][j - coins[0]];
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        Leetcode518 obj = new Leetcode518();
        int count = obj.change(5, new int[]{1, 2, 5});
//        int count = obj.change(41, new int[]{25, 10, 5, 1});
//        int count = obj.change(3, new int[]{2});
//        int count = obj.change(21, new int[]{15, 10, 1});
        System.out.println(count);
    }
}
