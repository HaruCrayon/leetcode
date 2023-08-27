package com.lee.algorithm.binarysearch;

/**
 * 35. 搜索插入位置
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode35 {
    /**
     * 二分查找-java版
     *
     * @param nums   待查找的升序数组，数组中无重复元素
     * @param target 待查找的目标值
     * @return 找到目标值，返回其索引。否则，返回它将会被按顺序插入的位置。
     */
    public int searchInsert1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return i;
    }

    // Leftmost版，能处理数组中有重复元素的情况
    public int searchInsert2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= nums[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
