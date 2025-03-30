package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * @description: 最大子数组和
 * @date: 2025/3/30
 */
public class Leetcode53 {
    /*
        nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
                -2  1  -2  4  3   5  6   1  5
     */
    public int maxSubArray(int[] nums) {
        int curSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = curSum > 0 ? curSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
