package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

/**
 * 101. 对称二叉树 - 递归求解
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode101 {

    /*
                  1
               /    \
              2      2
             / \    / \
            3  4   4  3
     */

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
