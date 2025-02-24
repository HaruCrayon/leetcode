package com.lee.algorithm.binarysearch;

/**
 * @description: 寻找旋转排序数组中的最小值
 * @author: LiJing
 * @date: 2025/2/24
 */
public class Leetcode153 {
    /*
        nums = [4,5,6,7,0,1,2]
     */

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) { // 最小值在mid左侧(或在mid处)
                right = mid;
            } else {// 最小值在mid右侧
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
