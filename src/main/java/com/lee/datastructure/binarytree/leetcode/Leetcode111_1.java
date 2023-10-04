package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

/**
 * 111. 二叉树的最小深度 - 后序遍历(递归)求解
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode111_1 {

    /*
           深度2
            1
           /
          2
     */
    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int d1 = minDepth(node.left);
        int d2 = minDepth(node.right);
        if (d1 == 0) { // 当左子树为null
            return d2 + 1;
        }
        if (d2 == 0) { // 当右子树为null
            return d1 + 1;
        }
        return Integer.min(d1, d2) + 1;
    }
}
