package com.lee.datastructure.array.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 用最少数量的箭引爆气球
 * @author: LiJing
 * @date: 2025/2/25
 */
public class Leetcode452 {

    public static int findMinArrowShots(int[][] points) {
        // 按照区间右端点排序
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[1]));
        int cnt = 1, pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                cnt++;
                pre = points[i][1];
            }
        }
        return cnt;
    }
}
