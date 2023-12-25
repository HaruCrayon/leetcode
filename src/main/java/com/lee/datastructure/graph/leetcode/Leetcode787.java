package com.lee.datastructure.graph.leetcode;

import java.util.Arrays;

/**
 * 787. K站中转内最便宜的航班
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode787 {

    // Bellman-Ford 单源最短路径算法
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = Integer.MAX_VALUE;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] f : flights) {
            graph[f[0]][f[1]] = f[2];
        }

        // 为每个顶点分配一个临时价格值
        int[] price = new int[n];
        Arrays.fill(price, INF);
        price[src] = 0;

        // 进行 k+1 轮处理
        for (int limit = 0; limit < k + 1; limit++) {
            int[] clone = price.clone();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (clone[i] != INF && graph[i][j] != INF && clone[i] + graph[i][j] < price[j]) {
                        price[j] = clone[i] + graph[i][j];
                    }
                }
            }
        }

        return price[dst] == INF ? -1 : price[dst];
    }

    // 测试
    public static void main(String[] args) {
        Leetcode787 obj = new Leetcode787();
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int n = 3, src = 0, dst = 2, k = 1;
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }
}
