package com.lee.datastructure.graph.leetcode;

/**
 * 547. 省份数量
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode547 {

    // 并查集合
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        DisjointSet set = new DisjointSet(size);
        int unionCount = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (isConnected[i][j] == 1) {
                    int x = set.find(i);
                    int y = set.find(j);
                    if (x != y) {
                        set.union(x, y);
                        unionCount++;
                    }
                }
            }
        }
        return size - unionCount;
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

        // find 是找到老大
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

    public static void main(String[] args) {
        Leetcode547 obj = new Leetcode547();
//        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(obj.findCircleNum(isConnected));
    }
}
