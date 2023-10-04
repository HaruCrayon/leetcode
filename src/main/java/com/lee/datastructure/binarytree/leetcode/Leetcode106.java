package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

import java.util.Arrays;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode106 {

    /*
        inOrder = {4,2,1,6,3,7}
        postOrder = {4,2,6,7,3,1}

        根 1
           in        post
        左 4,2       4,2
        右 6,3,7     6,7,3
     */

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder.length == 0) {
            return null;
        }
        // 创建根节点
        int rootValue = postOrder[postOrder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        // 切分左右子树
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                // 0 ~ i-1 左子树
                // i+1 ~ inOrder.length -1 右子树
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i); // [4,2]
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length); // [6,3,7]

                int[] postLeft = Arrays.copyOfRange(postOrder, 0, i); // [4,2]
                int[] postRight = Arrays.copyOfRange(postOrder, i, postOrder.length - 1); // [6,7,3]

                root.left = buildTree(inLeft, postLeft); // 2
                root.right = buildTree(inRight, postRight); // 3
                break;
            }
        }
        return root;
    }
}
