package com.lee.datastructure.array.leetcode;

/**
 * 189. 轮转数组
 *
 * @author LiJing
 * @date 2024-02-27
 */
public class Leetcode189 {
    /*
                            0     k     n-1
                    nums = [1,2,3,4,5,6,7],  k = 3
        反转 0 ~ n-1       [7,6,5,4,3,2,1]
        反转 0 ~ k-1       [5,6,7,4,3,2,1]
        反转 k ~ n-1       [5,6,7,1,2,3,4]
     */

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (n == 1 || k == 0) {
            return;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
