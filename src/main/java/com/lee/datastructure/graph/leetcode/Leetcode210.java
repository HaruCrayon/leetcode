package com.lee.datastructure.graph.leetcode;

import java.util.*;

/**
 * 210. 课程表 II
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode210 {

    // 广度优先搜索实现的拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 辅助变量
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();

        // 读取先修关系
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = map.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            map.put(src, list);
            inDegree[dest]++;
        }

        // 把入度为 0 的节点入队
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 访问
        int i = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            topologicalOrder[i++] = node;
            // 改变入度
            if (map.containsKey(node)) {
                for (Integer neighbor : map.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // 判断所有课程是否修完
        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }

    // 测试
    public static void main(String[] args) {
        Leetcode210 obj = new Leetcode210();
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
//        int numCourses = 2;
//        int[][] prerequisites = new int[][]{{1, 0}};
//        int numCourses = 1;
//        int[][] prerequisites = new int[][]{};
//        int numCourses = 4;
//        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {2, 3}};
        int[] order = obj.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }

}
