package com.lee.datastructure.graph.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1584. 连接所有点的最小费用
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode1584 {

    // 最小生成树 - Kruskal(克鲁斯卡尔) 算法
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v[2]));
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                queue.offer(new int[]{i, j, dist});
            }
        }

        ArrayList<int[]> list = new ArrayList<>();
        DisjointSet set = new DisjointSet(size);
        while (list.size() < size - 1) {
            int[] poll = queue.poll();
            int x = set.find(poll[0]);
            int y = set.find(poll[1]);
            if (x != y) {
                list.add(poll);
                set.union(x, y);
            }
        }

        int minCost = 0;
        for (int[] edge : list) {
            minCost += edge[2];
        }

        return minCost;
    }

    static class DisjointSet {
        int[] s;
        int[] size;

        public DisjointSet(int size) {
            s = new int[size];
            this.size = new int[size];
            for (int i = 0; i < size; i++) {
                s[i] = i;
                this.size[i] = 1;
            }
        }

        // find 是找到老大 - 优化：路径压缩
        public int find(int x) {
            if (x == s[x]) {
                return x;
            }
            return s[x] = find(s[x]);
        }

        // union 是让两个集合“相交”，即选出新老大，x、y 是原老大索引
        public void union(int x, int y) {
            if (size[x] < size[y]) {
                int t = x;
                x = y;
                y = t;
            }
            // x 新老大   y 新小弟
            s[y] = x;
            size[x] = size[x] + size[y];
        }
    }

    // 测试
    public static void main(String[] args) {
        Leetcode1584 obj = new Leetcode1584();
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
//        int[][] points = {{3, 12}, {-2, 5}, {-4, 1}};
//        int[][] points = {{0, 0}};
        System.out.println(obj.minCostConnectPoints(points));
    }
}
