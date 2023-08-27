package com.lee.algorithm.binarysearch;

/**
 * 704. 二分查找
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode704 {
    /**
     * 二分查找-基础版
     *
     * @param nums   待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到目标值，返回其索引。否则返回 -1
     */
    public int search1(int[] nums, int target) {
        int i = 0, j = nums.length - 1; // 设置指针和初值
        while (i <= j) {
            int m = (i + j) >>> 1; // 无符号右移
            if (target < nums[m]) { // 目标在左边
                j = m - 1;
            } else if (nums[m] < target) { // 目标在右边
                i = m + 1;
            } else { // 找到了
                return m;
            }
        }
        return -1; // 没找到
    }

    //改动版
    public int search2(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) { // 左
                j = m;
            } else if (nums[m] < target) { // 右
                i = m + 1;
            } else { // 找到了
                return m;
            }
        }
        return -1; // 没找到
    }

    //平衡版
    public int search3(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) { // 左
                j = m;
            } else { // 右, 或 m
                i = m;
            }
        }
        return (nums[i] == target) ? i : -1;
    }
}
