package com.lee.algorithm.greedy.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * <p>本质就是活动选择问题</p>
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[1]));
        int count = 1;
        int prev = 0;
        for (int curr = 1; curr < intervals.length; curr++) {
            if (intervals[curr][0] >= intervals[prev][1]) {
                count++;
                prev = curr;
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        Leetcode435 obj = new Leetcode435();
//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }
}
