package com.lee.datastructure.binarysearchtree.leetcode;

import java.util.LinkedList;

/**
 * 938. 二叉搜索树的范围和
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode938 {

    // 解法1. 中序遍历非递归实现 5ms
    public int rangeSumBST1(TreeNode node, int low, int high) {
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理值
                if (pop.val > high) {
                    break;
                }
                if (pop.val >= low) {
                    sum += pop.val;
                }
                p = pop.right;
            }
        }
        return sum;
    }

    // 解法2. 上下限递归实现 0ms
    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val < low) {
            return rangeSumBST(node.right, low, high);
        }
        if (node.val > high) {
            return rangeSumBST(node.left, low, high);
        }
        return node.val + rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
    }
}
