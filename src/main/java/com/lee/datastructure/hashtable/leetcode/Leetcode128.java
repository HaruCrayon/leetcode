package com.lee.datastructure.hashtable.leetcode;

import java.util.HashSet;

/**
 * @description: 最长连续序列
 * @author: LiJing
 * @date: 2025/2/14
 */
public class Leetcode128 {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int maxSeqLen = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int seqLen = 1;
                while (set.contains(++num)) {
                    seqLen++;
                }
                maxSeqLen = Math.max(maxSeqLen, seqLen);
            }
        }
        return maxSeqLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }
}
