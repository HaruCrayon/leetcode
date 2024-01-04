package com.lee.algorithm.dynamicprogramming.leetcode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>可以凑成总金额，所需的 最少的硬币个数</p>
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode322 {
    /*
     面值    0        1        2        3        4        5
       1    0        1        11       111      1111     11111
       2    0        1        2        21       22       221
       5    0        1        2        21       22       5

     面值    0        1        2        3        4        5
      10    0        max      max      max      max      max

     总金额    - 类比为背包容量
     硬币面值  - 类比为物品重量
     硬币个数  - 类比为物品价值，固定为1 （求价值(个数)最小的）

     if(装得下) {
        min(上次价值(个数), 剩余容量能装下的最小价值(个数)+1)
        dp[i][j] = min(dp[i-1][j], dp[i][j-item.weight] + 1)
     } else {
        保留上次价值(个数)不变
        dp[i][j] = dp[i-1][j]
     }
     */

    // 降维
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = Integer.min(dp[j], dp[j - coin] + 1);
            }
        }
        int r = dp[amount];
        return (r < amount + 1) ? r : -1;
    }

    public int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int j = 1; j < amount + 1; j++) {
            if (j >= coins[0]) {
                dp[0][j] = dp[0][j - coins[0]] + 1;
            } else {
                dp[0][j] = amount + 1;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int r = dp[coins.length - 1][amount];
        return (r < amount + 1) ? r : -1;
    }

    public static void main(String[] args) {
        Leetcode322 obj = new Leetcode322();
        int count = obj.coinChange(new int[]{1, 2, 5}, 11);
//        int count = obj.coinChange(new int[]{25, 10, 5, 1}, 41);
//        int count = obj.coinChange(new int[]{2}, 3);
//        int count = obj.coinChange(new int[]{15, 10, 1}, 21);
        System.out.println(count);
    }
}
