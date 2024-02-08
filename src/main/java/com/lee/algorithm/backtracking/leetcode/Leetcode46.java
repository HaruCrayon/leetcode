package com.lee.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    private void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        // 遍历 nums 数组，发现未被使用的数字，则将其标记为已使用，并加入 stack
        for (int i = 0; i < nums.length; i++) {
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
        Leetcode46 obj = new Leetcode46();
        List<List<Integer>> permute = obj.permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
}
