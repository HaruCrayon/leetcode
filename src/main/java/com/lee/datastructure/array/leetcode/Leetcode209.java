package com.lee.datastructure.array.leetcode;

/**
 * @description: 长度最小的子数组
 * @author: LiJing
 * @date: 2025/2/14
 */
public class Leetcode209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                int len = j - i + 1;
                if (len == 1) {
                    return 1;
                }
                minLen = Math.min(minLen, len);
                sum -= nums[i++];
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}
