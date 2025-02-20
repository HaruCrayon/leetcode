package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

/**
 * @description: 路径总和
 * @author: LiJing
 * @date: 2025/2/18
 */
public class Leetcode112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
