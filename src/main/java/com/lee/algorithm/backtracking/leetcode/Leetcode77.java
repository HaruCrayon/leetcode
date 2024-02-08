package com.lee.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, n, k, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int start, int n, int k, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 还差几个数字 > 剩余可用数字
            if (k - stack.size() > n - i + 1) { // 剪枝
                continue;
            }
            stack.push(i);
            dfs(i + 1, n, k, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Leetcode77 obj = new Leetcode77();
        List<List<Integer>> combine = obj.combine(4, 3);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }
}
