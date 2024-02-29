package com.lee.datastructure.string;

/**
 * 12. 整数转罗马数字
 *
 * @author LiJing
 * @date 2024-02-29
 */
public class Leetcode12 {
    /*
        1.建立一个数值-符号对的列表 values - symbols，按数值从大到小排列
        2.遍历列表中的每个数值-符号对：
        若当前数值 value 不超过 num，则从 num 中不断减去 value，直至 num 小于 value，然后遍历下一个数值-符号对
        3.若遍历中 num 为 0 则跳出循环
     */

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                sb.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
