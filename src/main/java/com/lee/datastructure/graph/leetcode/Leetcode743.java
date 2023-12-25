package com.lee.datastructure.graph.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 743. 网络延迟时间
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode743 {

    // Dijkstra 单源最短路径算法
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] t : times) {
            int s = t[0] - 1;
            int e = t[1] - 1;
            graph[s][e] = t[2];
        }

        // 1.为每个顶点分配一个临时距离值
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        // 标记顶点是否被访问
        boolean[] visited = new boolean[n];

        // 2.创建一个优先级队列，放入所有顶点
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.get(1)));
        for (int i = 0; i < n; i++) {
            queue.offer(Arrays.asList(i, dist[i]));
        }

        while (!queue.isEmpty()) {
            // 3.每次选择最小临时距离的未访问顶点，作为新的当前顶点
            Integer curr = queue.peek().get(0);
            // 4.对于当前顶点，遍历其所有未访问的邻居，并更新它们的临时距离为更小，若距离更新需加入队列
            if (!visited[curr]) {
                for (int i = 0; i < n; i++) {
                    if (!visited[i] && graph[curr][i] != INF && dist[curr] + graph[curr][i] < dist[i]) {
                        dist[i] = dist[curr] + graph[curr][i];
                        queue.offer(Arrays.asList(i, dist[i]));
                    }
                }
                visited[curr] = true;
            }
            // 5.当前顶点的邻居处理完成后，把它从队列中删除
            queue.poll();
        }

        int result = Arrays.stream(dist).max().getAsInt();
        return result == INF ? -1 : result;
    }

    // 测试
    public static void main(String[] args) {
        Leetcode743 obj = new Leetcode743();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
//        int[][] times = {{1, 2, 1}};
//        int n = 2, k = 1;
//        int[][] times = {{1, 2, 1}};
//        int n = 2, k = 2;
        int result = obj.networkDelayTime(times, n, k);
        System.out.println(result);
    }
}
