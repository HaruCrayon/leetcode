package com.lee.algorithm.shares;

/**
 * 123. 买卖股票的最佳时机 III
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode123 {
    /*
        某一天买入股票，未来任意一天卖出，只能先卖再买，最多买卖两次，求最大利润

        第一次买，不依赖之前状态，以当日价格买入
        第一次卖，依赖于昨天第一次买 + 当日价格

        第二次买，依赖于昨天第一次卖 - 当日价格
        第二次卖，依赖于昨天第二次买 + 当日价格
     */

    public static int maxProfit1(int[] prices) {
        // 昨天第一次买卖
        int _buy1 = Integer.MIN_VALUE;
        int _sell1 = 0;
        // 昨天第二次买卖
        int _buy2 = Integer.MIN_VALUE;
        int _sell2 = 0;
        for (int price : prices) {
            int buy1 = Math.max(_buy1, -price);
            int sell1 = Math.max(_sell1, _buy1 + price);
            int buy2 = Math.max(_buy2, _sell1 - price);
            int sell2 = Math.max(_sell2, _buy2 + price);
            _buy1 = buy1;
            _sell1 = sell1;
            _buy2 = buy2;
            _sell2 = sell2;
        }
        return _sell2;
    }

    // 结构优化（非性能）
    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 6
    }
}
