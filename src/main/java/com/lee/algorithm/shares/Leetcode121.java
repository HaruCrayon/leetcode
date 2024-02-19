package com.lee.algorithm.shares;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode121 {
    /*
     * 某一天买入股票，未来任意一天卖出，只能买卖一次，求最大利润
     *
     * i 尝试买入，j 尝试卖出
     * 遇到涨  i 不变, j++
     * 遇到跌  i 变 j，j++
     */

    public static int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int max = 0;
        while (j < prices.length) {
            int profit = prices[j] - prices[i];
            if (profit > 0) { // 涨
                max = Math.max(max, profit);
            } else { // 跌
                i = j;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
        System.out.println(maxProfit(new int[]{9, 3, 12, 1, 2, 3})); // 9
    }
}
