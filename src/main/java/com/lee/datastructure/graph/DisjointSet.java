package com.lee.datastructure.graph;

import java.util.Arrays;

/**
 * <h3>不相交集合（并查集合）</h3>
 */
public class DisjointSet {
    int[] s;
    // 索引对应顶点
    // 元素表示与之有关系的顶点
    /*
        索引  0  1  2  3  4  5  6
        元素 [0, 1, 2, 3, 4, 5, 6] 表示一开始顶点之间没有联系（只与自己有联系）
    */

    int[] size; // 老大所在集合的元素个数

    public DisjointSet(int size) {
        s = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            s[i] = i;
            this.size[i] = 1;
        }
    }

    // find 是找到老大
    // 优化1：路径压缩
    /*
        find(2) 0
          find(1) 0
           find(0)
     */
    public int find(int x) { // x = 2
        if (x == s[x]) {
            return x;
        }
        return s[x] = find(s[x]); // 0    s[2]=0
    }

    // union 是让两个集合“相交”，即选出新老大，x、y 是原老大索引
    // 优化2：union by size
    public void union(int x, int y) {
        if (size[x] < size[y]) {
            int t = x;
            x = y;
            y = t;
        }
        // x 新老大   y 新小弟
        s[y] = x;
        size[x] = size[x] + size[y]; // 更新老大所在集合的元素个数
    }

    @Override
    public String toString() {
        return "内容：" + Arrays.toString(s) + "\n大小：" + Arrays.toString(size);
    }
}
