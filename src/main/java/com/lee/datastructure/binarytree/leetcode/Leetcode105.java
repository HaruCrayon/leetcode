package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode105 {

    /*
        preOrder = {1,2,4,3,6,7}
        inOrder = {4,2,1,6,3,7}

        根 1
            pre         in
        左  2,4         4,2
        右  3,6,7       6,3,7

        根 2
        左 4

        根 3
        左 6
        右 7
     */

    public TreeNode buildTree01(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0) {
            return null;
        }
        // 创建根节点
        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        // 切分左右子树
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                // 0 ~ i-1 左子树
                // i+1 ~ inOrder.length -1 右子树
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i); // [4,2]
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length); // [6,3,7]

                int[] preLeft = Arrays.copyOfRange(preOrder, 1, i + 1); // [2,4]
                int[] preRight = Arrays.copyOfRange(preOrder, i + 1, preOrder.length); // [3,6,7]

                root.left = buildTree(preLeft, inLeft); // 2
                root.right = buildTree(preRight, inRight); // 3
                break;
            }
        }
        return root;
    }

    // 优化
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, map, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, Map<Integer, Integer> map,
                               int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin > preEnd) {
            return null;
        }
        // 创建根节点
        int rootValue = preorder[preBegin];
        TreeNode root = new TreeNode(rootValue);
        // 切分左右子树
        Integer idx = map.get(rootValue);
        root.left = recursion(preorder, map, preBegin + 1, preBegin + idx - inBegin, inBegin, idx - 1);
        root.right = recursion(preorder, map, preBegin + idx - inBegin + 1, preEnd, idx + 1, inEnd);
        return root;
    }
}
