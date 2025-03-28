package com.lee.algorithm.dynamicprogramming.leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @description: 单词拆分
 * @date: 2025/3/27
 */
public class Leetcode139 {

    // s = "leetcode", wordDict = ["leet", "code"]

    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
