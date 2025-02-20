package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

/**
 * @description: 二叉树的最近公共祖先
 * @author: LiJing
 * @date: 2025/2/19
 */
public class Leetcode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左右子树查到节点都不为空，则表明p和q分别在左右子树中，因此，当前节点即为最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 如果左右子树其中一个不为空，则返回非空节点
        return left != null ? left : right;
    }
}
