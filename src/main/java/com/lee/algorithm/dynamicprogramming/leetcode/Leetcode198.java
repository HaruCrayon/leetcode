package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * 198. 打家劫舍
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode198 {
    /*

        价值   0   1   2   3   4
              0   0   0   0   0
        0(2)  2   0   0   0   0
        1(7)  2   7   0   0   0
        2(9)  2   7   11  0   0
        3(3)  2   7   11  11  0
        4(1)  2   7   11  11  12

        dp[4] = dp[2]+1 = 12
        dp[3] = max(dp[1]+3, dp[2]) = max(10, 11) = 11

        dp[i] = max(dp[i-2]+value, dp[i-1])
     */

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Integer.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Leetcode198 obj = new Leetcode198();
        System.out.println(obj.rob(new int[]{2, 7, 9, 3, 1})); // 12
        System.out.println(obj.rob(new int[]{1, 2, 3, 1})); // 4
    }
}
