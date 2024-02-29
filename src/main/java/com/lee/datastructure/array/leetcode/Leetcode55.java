package com.lee.datastructure.array.leetcode;

/**
 * 55. 跳跃游戏
 *
 * @author LiJing
 * @date 2024-02-28
 */
public class Leetcode55 {
    /*
        [2,3,1,1,4]
         2 4
        [3,2,1,0,4]
         3 3 3 3
     */

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int maxIdx = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxIdx >= i) {
                maxIdx = Math.max(maxIdx, i + nums[i]);
                if (maxIdx >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
