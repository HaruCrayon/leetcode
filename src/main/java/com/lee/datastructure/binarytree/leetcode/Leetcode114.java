package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

/**
 * @description: 二叉树展开为链表
 * @author: LiJing
 * @date: 2025/2/20
 */
public class Leetcode114 {

    /*
              3                            3
            /   \                           \
          /       \                          \
         9         20                         9
      /   \       /   \                     /  \
    13     7     5      4                 13    7
          /                                    /
        6                                     6
                                               \
                                               20
                                             /   \
                                            5      4
     */

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode temp = cur.left, pre = null;
            while (temp != null) {
                pre = temp;
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp = temp.left;
                }
            }
            if (pre != null) {
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
