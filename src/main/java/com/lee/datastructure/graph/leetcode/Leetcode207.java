package com.lee.datastructure.graph.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            return true;
        }

        return false;
    }
}
