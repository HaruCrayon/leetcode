package com.lee.datastructure.binarysearchtree.leetcode;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode235 {

    /*
            __ 6 __
           /       \
          2         8
         / \       / \
        0   4     7   9
           / \
          3   5

          待查找节点 p q 在某一节点的两侧，那么此节点就是最近的公共祖先 (祖先也包括自己)
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root;
        while (p.val < a.val && q.val < a.val || a.val < p.val && a.val < q.val) { // p,q 在同一侧
            if (p.val < a.val) {
                a = a.left;
            } else {
                a = a.right;
            }
        }
        return a;
    }
}
