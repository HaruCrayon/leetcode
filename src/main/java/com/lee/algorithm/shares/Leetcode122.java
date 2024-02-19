package com.lee.algorithm.shares;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode122 {
    /*
        某一天买入股票，未来任意一天卖出，只能卖了再买，但可以买卖多次，并允许同一天卖出后再买入，求最大利润

        有利润就买卖，只看眼前（贪心算法）
     */

    public static int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int sum = 0;
        while (j < prices.length) {
            int profit = prices[j] - prices[i];
            if (profit > 0) { // 有利润
                sum += profit;
            }
            i++;
            j++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{9, 3, 12, 1, 2, 3})); // 11
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 7
    }
}
