package com.lee.algorithm.sort.leetcode;

import java.util.Arrays;

/**
 * 1636. 按照频率将数组升序排序
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode1636 {
    /*
        给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。
        如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。

        元素值范围 [-100, 100]
        数组长度 <= 100
     */

    public int[] frequencySort(int[] nums) {
        // 1. 统计出现频率
        int[] count = new int[201];
        for (int i : nums) {
            count[i + 100]++;
        }
        // 2. 比较器 按频率升序、再按数值降序
        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            int af = count[a + 100];
            int bf = count[b + 100];
            if (af < bf) {
                return -1;
            } else if (af > bf) {
                return 1;
            } else {
                return b - a;
            }
        }).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(new Leetcode1636().frequencySort(nums)));
    }
}
