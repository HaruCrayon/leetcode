package com.lee.datastructure.array.leetcode;

/**
 * 26. 删除有序数组中的重复项
 *
 * @author LiJing
 * @date 2024-02-27
 */
public class Leetcode26 {
    /*
                 i           j
        [0,0,1,1,1,2,2,3,3,4]
         0 1 2 3 4

     */

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
