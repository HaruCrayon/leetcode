package com.lee.algorithm.dynamicprogramming.leetcode;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode300 {
    /*
                    1       2       3       4
            1       3       6       4       9
            1       13      16      14      19
                            136     134     139
                                            169
                                            1369
                                            149
                                            1349
           (1)     (2)     (3)     (3)      (4)

     */

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            for (int j = 0; j < i; j++) {
                if (x > nums[j]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Leetcode300 obj = new Leetcode300();
        System.out.println(obj.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(obj.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); // 4
        System.out.println(obj.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})); // 1
        System.out.println(obj.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6})); // 6
    }
}
