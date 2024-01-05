package com.lee.algorithm.dynamicprogramming.leetcode;

/**
 * 718. 最长重复子数组
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode718 {

    // 降维
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length];
        int max = 0;
        for (int k : nums1) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (k == nums2[j]) {
                    if (j == 0) {
                        dp[j] = 1;
                    } else {
                        dp[j] = dp[j - 1] + 1;
                    }
                    max = Integer.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return max;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Integer.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode718 obj = new Leetcode718();
        System.out.println(obj.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(obj.findLength(new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 1, 1}));
    }

    /*
            1  0  0  1  1
        1   1  0  0  1  1
        0   0  2  1  0  0
        0   1  1  3  1  1
        0   0  2  2  0  0
        1   1  0  0  3  1
     */
}
