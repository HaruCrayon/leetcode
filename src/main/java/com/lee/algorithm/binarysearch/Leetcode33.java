package com.lee.algorithm.binarysearch;

/**
 * @description: 搜索旋转排序数组
 * @author: LiJing
 * @date: 2025/2/24
 */
public class Leetcode33 {
    /*
        nums = [4,5,6,7,0,1,2]
     */

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) { // [left, mid] 是有序区间
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // [mid, right] 是有序区间
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
