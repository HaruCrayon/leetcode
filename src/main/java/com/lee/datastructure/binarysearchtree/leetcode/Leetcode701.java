package com.lee.datastructure.binarysearchtree.leetcode;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode701 {

    /*
        给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。
        返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
     */
    public TreeNode insertIntoBST(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insertIntoBST(node.left, val);
        } else if (node.val < val) {
            node.right = insertIntoBST(node.right, val);
        }
        return node;
    }
}
