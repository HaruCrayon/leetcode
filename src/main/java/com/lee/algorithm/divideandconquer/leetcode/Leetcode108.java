package com.lee.algorithm.divideandconquer.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

/**
 * @description: 将有序数组转换为二叉搜索树
 * @date: 2025/3/29
 */
public class Leetcode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    private TreeNode recursion(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(nums[i]);
        }
        int m = (i + j) >> 1;
        TreeNode left = recursion(nums, i, m - 1);
        TreeNode right = recursion(nums, m + 1, j);
        return new TreeNode(left, nums[m], right);
    }
}
