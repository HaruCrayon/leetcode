package com.lee.datastructure.hashtable.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 217. 存在重复元素
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode217 {
    /*
        给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     */

    public boolean containsDuplicate01(int[] nums) {
        HashMap<Integer, Object> map = new HashMap<>(nums.length * 2);
        Object value = new Object();
        for (int key : nums) {
            Object put = map.put(key, value);
            if (put != null) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int key : nums) {
            if (!set.add(key)) {
                return true;
            }
        }
        return false;
    }
}
