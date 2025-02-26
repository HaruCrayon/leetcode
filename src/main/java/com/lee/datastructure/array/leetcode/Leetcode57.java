package com.lee.datastructure.array.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 插入区间
 * @author: LiJing
 * @date: 2025/2/25
 */
public class Leetcode57 {
    /*
        输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        输出：[[1,2],[3,10],[12,16]]
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> merged = new ArrayList<>();
        boolean flag = false; // 标记newInterval是否被处理
        int i = 0;
        for (; i < intervals.length; i++) {
            int low = intervals[i][0], high = intervals[i][1];
            if (high < start) { // [low, high]  [start, end]
                merged.add(new int[]{low, high});
            } else { // start<=high
                if (end < low) { // [start, end]  [low, high]
                    merged.add(new int[]{start, end});
                    merged.add(new int[]{low, high});
                } else { // low<=end
                    // [low, high]               [low,   high]                   [low, high]
                    //      [start, end]            [start,   end]        [start, end]
                    merged.add(new int[]{Math.min(low, start), Math.max(high, end)});
                }
                flag = true;
                break;
            }
        }
        if (!flag) {
            merged.add(new int[]{start, end});
        }
        for (int j = i + 1; j < intervals.length; j++) {
            int low = intervals[j][0], high = intervals[j][1];
            if (low > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[]{low, high});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], high);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
