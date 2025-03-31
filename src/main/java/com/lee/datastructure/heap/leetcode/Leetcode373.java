package com.lee.datastructure.heap.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description: 查找和最小的 K 对数字
 * @date: 2025/3/31
 */
public class Leetcode373 {
    /*
        (0,0),(1,0),(2,0),(3,0),…,(k−1,0)
        (0,1),(1,1),(2,1),(3,1),…,(k−1,1)
        (0,2),(1,2),(2,2),(3,2),…,(k−1,2)
     */

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>(k);
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> nums1[o[0]] + nums2[o[1]]));
        for (int i = 0; i < Math.min(m, k); i++) {
            heap.offer(new int[]{i, 0});
        }
        for (int i = 0; i < k; i++) {
            int[] poll = heap.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            ans.add(list);
            if (poll[1] + 1 < n) {
                heap.offer(new int[]{poll[0], poll[1] + 1});
            }
        }
        return ans;
    }
}
