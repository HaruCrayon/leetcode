package com.lee.datastructure.array.leetcode;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * @author LiJing
 * @date 2024-02-27
 */
public class Leetcode80 {
    /*
                     i     j
        [0,0,1,1,1,1,2,3,3]
         0 0 1 1 2 3 3
     */

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 1;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
