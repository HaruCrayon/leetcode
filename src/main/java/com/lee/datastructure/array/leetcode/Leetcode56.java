package com.lee.datastructure.array.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 合并区间
 * @author: LiJing
 * @date: 2025/2/25
 */
public class Leetcode56 {
    /*
        [[1,9], [2,5], [19,20], [10,11], [12,20], [0,3], [0,1], [0,2]]

        按照左端点升序排序后：
        [[0,3], [0,1], [0,2], [1,9], [2,5], [10,11], [12,20], [19,20]]
     */

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 将数组中的区间按照左端点升序排序
        Arrays.sort(intervals, (arr1, arr2) -> (arr1[0] - arr2[0]));
        // 用列表 merged 存储最终的答案
        List<int[]> merged = new ArrayList<>();
        // 将第一个区间加入 merged 列表中
        merged.add(intervals[0]);
        // 按顺序依次考虑之后的每个区间
        for (int i = 1; i < intervals.length; i++) {
            int low = intervals[i][0], high = intervals[i][1];
            // 如果当前区间的左端点在列表 merged 中最后一个区间的右端点之后，那么它们不会重合
            if (low > merged.get(merged.size() - 1)[1]) {
                // 直接将这个区间加入列表 merged 的末尾
                merged.add(new int[]{low, high});
            } else { // 否则，它们重合
                // 用当前区间的右端点更新列表 merged 中最后一个区间的右端点，将其置为二者的较大值
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], high);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
