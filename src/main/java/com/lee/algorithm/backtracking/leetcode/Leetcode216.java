package com.lee.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode216 {

    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, k, target, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int start, int k, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (target == 0 && stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (target < i) {
                break;
            }
            if (stack.size() == k) {
                break;
            }
            stack.push(i);
            dfs(i + 1, k, target - i, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Leetcode216 obj = new Leetcode216();
        List<List<Integer>> lists = obj.combinationSum3(3, 9);
//        List<List<Integer>> lists = obj.combinationSum3(2, 18);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
