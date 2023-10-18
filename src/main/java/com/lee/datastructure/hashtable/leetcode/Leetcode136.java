package com.lee.datastructure.hashtable.leetcode;

import java.util.HashSet;

/**
 * 136. 只出现一次的数字
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode136 {
    /*
        给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。
        找出那个只出现了一次的元素。
     */

    /*
        思路1
        1. 准备一个 Set 集合，逐一放入数组元素
        2. 遇到重复的，则删除
        3. 最后留下来的，就是那个没有重复的数字
     */
    public int singleNumber01(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.toArray(new Integer[0])[0];
    }

    /*
        思路2
        1. 任何相同的数字异或，结果都是 0
        2. 任何数字与 0 异或，结果是数字本身
     */
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
