package com.lee.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 四数之和
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(4, 0, nums.length - 1, nums, target, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int n, int i, int j, int[] nums, long target,
                     LinkedList<Integer> stack, List<List<Integer>> result) {
        if (n == 2) {
            // 两数之和求解
            twoSum(i, j, nums, target, stack, result);
            return;
        }
        // 四数之和 k < j-2   三数之和 k < j-1
        for (int k = i; k < j - (n - 2); k++) {
            // 检查重复
            if (k > i && nums[k] == nums[k - 1]) {
                continue;
            }
            // 固定一个数字，再尝试 n-1 数字之和
            stack.push(nums[k]);
            dfs(n - 1, k + 1, j, nums, target - nums[k], stack, result);
            stack.pop();
        }
    }

    private void twoSum(int i, int j, int[] nums, long target,
                        LinkedList<Integer> stack, List<List<Integer>> result) {
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else { // 找到解
                ArrayList<Integer> list = new ArrayList<>(stack);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                // 继续查找其它解
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Leetcode18 obj = new Leetcode18();
        List<List<Integer>> lists = obj.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
//        List<List<Integer>> lists = obj.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
