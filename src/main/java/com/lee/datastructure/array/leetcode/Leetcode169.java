package com.lee.datastructure.array.leetcode;

/**
 * 169. 多数元素
 *
 * @author LiJing
 * @date 2024-02-27
 */
public class Leetcode169 {
    /*
        不同的元素两两消失，最后剩余的一定是超过半数的元素
     */

    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (nums[i] == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
