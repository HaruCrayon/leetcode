package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * @description: 环形子数组的最大和
 * @date: 2025/3/30
 */
public class Leetcode918 {
    /*
        情况一：[i : j]
        情况二：[0 : i]    [j : n-1]
     */

    // 方法一
    public int maxSubarraySumCircular2(int[] nums) {
        int n = nums.length;
        int curSum = nums[0], res = nums[0], leftSum = nums[0];
        int[] leftMax = new int[n]; // 最大前缀和
        leftMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            curSum = curSum > 0 ? curSum + nums[i] : nums[i];
            res = Math.max(res, curSum);
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftSum);
        }

        // 从右到左枚举后缀，固定后缀，选择最大前缀
        int rightSum = 0;
        for (int i = n - 1; i > 0; i--) {
            rightSum += nums[i];
            res = Math.max(res, rightSum + leftMax[i - 1]);
        }

        return res;
    }

    // 方法二
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int curMin = nums[0], curMax = nums[0], maxSum = nums[0], minSum = nums[0], sum = nums[0];
        for (int i = 1; i < n; i++) {
            curMax = curMax > 0 ? curMax + nums[i] : nums[i];
            curMin = curMin < 0 ? curMin + nums[i] : nums[i];
            maxSum = Math.max(maxSum, curMax);
            minSum = Math.min(minSum, curMin);
            sum += nums[i];
        }
        if (maxSum < 0) {
            return maxSum;
        }
        return Math.max(maxSum, sum - minSum);
    }
}
