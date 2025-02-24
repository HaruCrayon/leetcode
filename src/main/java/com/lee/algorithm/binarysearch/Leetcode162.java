package com.lee.algorithm.binarysearch;

/**
 * @description: 寻找峰值
 * @author: LiJing
 * @date: 2025/2/24
 */
public class Leetcode162 {
    /*
        nums = [1,2,1,3,5,6,4]
     */

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
