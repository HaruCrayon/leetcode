package com.lee.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, new boolean[candidates.length], new LinkedList<>(), result);
        return result;
    }

    private void dfs(int start, int[] candidates, int target, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                break;
            }
            if (i > 0 && candidate == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            stack.push(candidate);
            dfs(i + 1, candidates, target - candidate, visited, stack, result);
            stack.pop();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Leetcode40 obj = new Leetcode40();
//        List<List<Integer>> lists = obj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        List<List<Integer>> lists = obj.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
