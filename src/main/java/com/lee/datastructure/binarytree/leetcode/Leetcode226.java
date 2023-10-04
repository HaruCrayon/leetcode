package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode226 {

    public TreeNode invertTree(TreeNode root) {
        fn(root);
        return root;
    }

    private void fn(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;

        fn(node.left);
        fn(node.right);
    }
}
