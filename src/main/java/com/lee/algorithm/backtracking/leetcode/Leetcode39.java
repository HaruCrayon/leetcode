package com.lee.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int start, int[] candidates, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                break;
            }
            stack.push(candidate);
            dfs(i, candidates, target - candidate, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Leetcode39 obj = new Leetcode39();
        List<List<Integer>> lists = obj.combinationSum(new int[]{2, 3, 6, 7}, 7);
//        List<List<Integer>> lists = obj.combinationSum(new int[]{2, 3, 5}, 8);
//        List<List<Integer>> lists = obj.combinationSum(new int[]{2}, 1);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
