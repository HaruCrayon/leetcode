package com.lee.algorithm.shares;

/**
 * 714. 买卖股票的最佳时机含手续费
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode714 {
    /*
        某一天买入股票，未来任意一天卖出，只能卖了再买，但可以买卖多次，每笔交易有手续费，求最大利润

        fee：2
            0       1           2            3           4         5
            1       3           2            8           4         9
     买     -1     等-1 √       等-1 √       等-1 √     等-1       等1 √
                   买-3         买-2        买-8        买1 √     买-4
     卖     0      等0  √        等0  √      等0        等5 √     等5
                   卖0          卖-1         卖5 √      卖1       卖8 √

        动态规划
        对于买：1.延续上次买的利润不变
               2.在上次卖的利润基础上买
        对于卖：1.延续上次卖的利润不变
               2.在上次买的利润基础上卖
     */

    public static int maxProfit1(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }

    // 降维
    public static int maxProfit2(int[] prices, int fee) {
        // _buy _sell 代表上一次， buy sell 代表这一次
        int _buy = -prices[0];
        int _sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int buy = Math.max(_buy, _sell - prices[i]);
            int sell = Math.max(_sell, _buy + prices[i] - fee);
            _buy = buy;
            _sell = sell;
        }
        return _sell;
    }

    // 结构优化（非性能）
    public static int maxProfit(int[] prices, int fee) {
        // 设置 buy 的初始值为最小，可以让循环统一从 0 开始
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }
        return sell;
    }

    public static void main(String[] args) {
        // 两次交易的情况
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2)); // 8
        System.out.println(maxProfit(new int[]{1, 3, 7, 2, 18, 3}, 3)); // 16
        System.out.println(maxProfit(new int[]{2, 1, 4, 4, 2, 3, 2, 5, 1, 2}, 1)); // 4
        System.out.println(maxProfit(new int[]{9, 3, 12, 1, 2, 3}, 1)); // 9

        // 一次交易的情况
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3)); // 6
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 11, 3}, 3)); // 7
    }
}
