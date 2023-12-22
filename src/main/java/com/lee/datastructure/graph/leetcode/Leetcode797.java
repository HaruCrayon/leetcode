package com.lee.datastructure.graph.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, result, path);
        return result;
    }

    private void dfs(int[][] graph, int x, List<List<Integer>> result, List<Integer> path) {
        path.add(x);
        if (x == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i : graph[x]) {
            dfs(graph, i, result, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int[][] graph = {{1, 2}, {3}, {3}, {}};
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        Leetcode797 obj = new Leetcode797();
        List<List<Integer>> result = obj.allPathsSourceTarget(graph);
        System.out.println(result);
    }
}
