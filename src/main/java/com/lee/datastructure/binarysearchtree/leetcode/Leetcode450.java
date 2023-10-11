package com.lee.datastructure.binarysearchtree.leetcode;

import com.lee.datastructure.binarysearchtree.BSTTree1;

/**
 * 450. 删除二叉搜索树中的节点
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode450 {

    /**
     * 递归实现
     *
     * @param node 二叉搜索树的根节点 root
     * @param key
     * @return 二叉搜索树（有可能被更新）的根节点的引用
     */
    public TreeNode deleteNode1(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        }
        if (node.val < key) {
            node.right = deleteNode(node.right, key);
            return node;
        }
        if (node.left == null) { // 情况1 - 没有左孩子
            return node.right;
        }
        if (node.right == null) { // 情况2 - 没有右孩子
            return node.left;
        }
        TreeNode s = node.right; // 情况3 - 有两个孩子
        while (s.left != null) {
            s = s.left;
        }
        s.right = deleteNode(node.right, s.val);
        s.left = node.left;
        return s;
    }

    /**
     * 非递归实现
     *
     * @param root 二叉搜索树的根节点
     * @param key
     * @return 二叉搜索树（有可能被更新）的根节点的引用
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null) {
            if (key < p.val) {
                parent = p;
                p = p.left;
            } else if (p.val < key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return root;
        }
        // 删除操作
        if (p.left == null) {
            shift(root, parent, p, p.right); // 情况1 - 没有左孩子
        } else if (p.right == null) {
            shift(root, parent, p, p.left); // 情况2 - 没有右孩子
        } else {
            // 情况4 - 有两个孩子
            // 4.1 被删除节点找后继
            TreeNode s = p.right;
            TreeNode sParent = p; // 后继父亲
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // 后继节点即为 s
            if (sParent != p) { // 不相邻
                // 4.2 删除和后继不相邻, 处理后继的后事
                shift(null, sParent, s, s.right); // 不可能有左孩子
                s.right = p.right;
            }
            // 4.3 后继取代被删除节点
            shift(root, parent, p, s);
            s.left = p.left;
        }

        return root;
    }

    /**
     * 托孤方法
     *
     * @param root    根节点
     * @param parent  被删除节点的父亲
     * @param deleted 被删除节点
     * @param child   被顶上去的节点
     */
    private void shift(TreeNode root, TreeNode parent, TreeNode deleted, TreeNode child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
}
