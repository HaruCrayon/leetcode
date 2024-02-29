package com.lee.datastructure.array.leetcode;

/**
 * 45. 跳跃游戏 II
 *
 * @author LiJing
 * @date 2024-02-28
 */
public class Leetcode45 {
    /*

                 0  1  2  3  4  5  6
                [2, 3, 1, 2, 4, 2, 3]
                 2  4  3  5  8  7
                    √        √     √

          贪心思想：每次在上次能跳到的范围内选择一个能跳的最远的位置作为下次的起跳点
          1. 维护当前能够到达的最大下标位置，记为边界 end
          2. 从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1

     */

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int end = 0;
        int maxIdx = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIdx = Math.max(maxIdx, i + nums[i]);
            if (i == end) {
                end = maxIdx;
                steps++;
            }
        }
        return steps;
    }
}
