package com.lee.algorithm.binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode34 {
    /**
     * @param nums   有重复元素的升序数组
     * @param target 待查找的目标值
     * @return 返回目标值在数组中的开始位置和结束位置。如果数组中不存在目标值，返回 [-1, -1]
     */
    public int[] searchRange(int[] nums, int target) {
        int left = leftOrRight(nums, target, true);
        if (left == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, leftOrRight(nums, target, false)};
        }
    }

    /**
     * 二分查找 Leftmost、Rightmost
     *
     * @param nums   有重复元素的升序数组
     * @param target 待查找的目标值
     * @param flag   true：Leftmost    false：Rightmost
     * @return 找到则返回最靠左（右）索引。找不到返回 -1
     */
    public int leftOrRight(int[] nums, int target, boolean flag) {
        int i = 0, j = nums.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                if (flag) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
        }
        return candidate;
    }
}
