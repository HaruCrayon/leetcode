package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public TreeNode buildTree01(int[] inOrder, int[] postOrder) {
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

    // 优化
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return recursion(postOrder, map, 0, postOrder.length - 1, 0, postOrder.length - 1);
    }

    private TreeNode recursion(int[] preorder, Map<Integer, Integer> map,
                               int postBegin, int postEnd, int inBegin, int inEnd) {
        if (postBegin > postEnd) {
            return null;
        }
        // 创建根节点
        int rootValue = preorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        // 切分左右子树
        Integer idx = map.get(rootValue);
        root.left = recursion(preorder, map, postBegin, postBegin + idx - inBegin - 1, inBegin, idx - 1);
        root.right = recursion(preorder, map, postBegin + idx - inBegin, postEnd - 1, idx + 1, inEnd);
        return root;
    }
}
