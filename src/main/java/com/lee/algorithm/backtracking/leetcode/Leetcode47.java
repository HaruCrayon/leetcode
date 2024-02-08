package com.lee.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    private void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) { // 剪枝
                continue;
            }
            if (!visited[i]) {
                stack.push(nums[i]);
                visited[i] = true;
                dfs(nums, visited, stack, result);
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Leetcode47 obj = new Leetcode47();
        List<List<Integer>> permute = obj.permuteUnique(new int[]{1, 1, 3});
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
}
