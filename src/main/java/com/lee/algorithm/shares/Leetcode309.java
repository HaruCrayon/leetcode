package com.lee.algorithm.shares;

/**
 * 309. 买卖股票的最佳时机含冷冻期
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode309 {
    /*
        某一天买入股票，未来任意一天卖出，可以买卖多次，卖出后只能隔天再买入，求最大利润

            0       1           2           3           4
            1       2           3           0           2
     买     -1      -2          -3          1√          0
     等             -1√         -1√         -1          1√
     卖     0       1√          2√          -1          3√
     等             0           1           2√          2

     */

    public static int maxProfit1(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], sell[0] - prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    // 降维
    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int _buy = -prices[0]; // 前一天买
        int _sell = 0; // 前一天卖
        int _sell2 = 0; // 前两天卖
        for (int i = 1; i < prices.length; i++) {
            int buy = Math.max(_buy, _sell2 - prices[i]);
            int sell = Math.max(_sell, _buy + prices[i]);
            _buy = buy;
            _sell2 = _sell;
            _sell = sell;
        }
        return _sell;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2})); // 3
    }
}
