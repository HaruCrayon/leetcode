package com.lee.algorithm.divideandconquer.leetcode;

import com.lee.algorithm.divideandconquer.QuickSelect;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode215 {
    /**
     * <h3>求数组中第 K 大的元素 - 快速选择算法</h3>
     * <ul>
     *     <li>时间复杂度 O(n)</li>
     * </ul>
     */
    public int findKthLargest(int[] nums, int k) {
        return QuickSelect.quick(nums, 0, nums.length - 1, nums.length - k);
    }

    public static void main(String[] args) {
        Leetcode215 obj = new Leetcode215();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(obj.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
    }
}
