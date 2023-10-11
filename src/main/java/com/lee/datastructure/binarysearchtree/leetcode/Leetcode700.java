package com.lee.datastructure.binarysearchtree.leetcode;

/**
 * 700. 二叉搜索树中的搜索
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode700 {
    /*
        给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
        你需要在 BST 中找到节点值等于 val 的节点。
        返回以该节点为根的子树。 如果节点不存在，则返回 null 。
     */
    public TreeNode searchBST(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (val < node.val) {
            return searchBST(node.left, val);
        } else if (node.val < val) {
            return searchBST(node.right, val);
        } else {
            return node;
        }
    }
}
