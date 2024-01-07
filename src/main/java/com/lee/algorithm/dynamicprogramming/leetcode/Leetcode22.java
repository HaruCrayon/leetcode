package com.lee.algorithm.dynamicprogramming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        ArrayList<String>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>(Arrays.asList(""));
        dp[1] = new ArrayList<>(Arrays.asList("()"));
        for (int j = 2; j < n + 1; j++) {
            dp[j] = new ArrayList<>();
            for (int i = 0; i < j; i++) { // 第j个卡特兰数的拆分
                // i 对应的集合是内层要嵌套的括号, j - 1 - i 对应的集合是平级要拼接的括号
                for (String k1 : dp[i]) {
                    for (String k2 : dp[j - 1 - i]) {
                        dp[j].add("(" + k1 + ")" + k2);
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode22 obj = new Leetcode22();
        System.out.println(obj.generateParenthesis(3)); // [()()(), ()(()), (())(), (()()), ((()))]
    }
}
