package com.lee.datastructure.hashtable.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: 存在重复元素 II
 * @author: LiJing
 * @date: 2025/2/13
 */
public class Leetcode219 {

    // 方法二：滑动窗口
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 使用哈希集合存储滑动窗口中的元素
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    // 方法一：哈希表
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
