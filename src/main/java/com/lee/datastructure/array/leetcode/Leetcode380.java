package com.lee.datastructure.array.leetcode;

import java.util.*;

/**
 * @author LiJing
 * @date 2024-02-28
 */
public class Leetcode380 {
    /*
        数组存储值（实现O(1)插入、随机读）
        哈希表存储值及对应的索引（实现O(1)查找）
        删除时将要删除的数与数组最后一个数交换位置（避免移动，实现O(1)删除）

     */

    static class RandomizedSet {
        private final List<Integer> list;
        private final Map<Integer, Integer> map;
        private int size;
        private final Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, size);
            size++;
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int idx = map.get(val);
            // 交换位置
            int last = list.get(size - 1);
            list.set(idx, last);
            map.put(last, idx);
            // 删除
            list.remove(size - 1);
            map.remove(val);
            size--;
            return true;
        }

        public int getRandom() {
            int rdmIdx = random.nextInt(size);
            return list.get(rdmIdx);
        }
    }
}
