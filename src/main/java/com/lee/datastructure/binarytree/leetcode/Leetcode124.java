package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

/**
 * @description: 二叉树中的最大路径和
 * @author: LiJing
 * @date: 2025/2/21
 */
public class Leetcode124 {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和
        int sum = node.val + leftGain + rightGain;
        // 更新答案
        maxSum = Math.max(maxSum, sum);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
