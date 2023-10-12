package com.lee.datastructure.binarysearchtree.leetcode;

/**
 * 1008. 前序遍历构造二叉搜索树
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode1008 {

    // 解法1. 直接插入
    public TreeNode bstFromPreorder1(int[] preorder) {
        TreeNode root = insert1(null, preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert1(root, preorder[i]);
        }
        return root;
    }

    private TreeNode insert1(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insert1(node.left, val);
        } else if (node.val < val) {
            node.right = insert1(node.right, val);
        }
        return node;
    }

    // 解法2. 上限法
    public TreeNode bstFromPreorder2(int[] preorder) {
        return insert(preorder, Integer.MAX_VALUE);
    }

    int i = 0;

    private TreeNode insert(int[] preorder, int max) {
        if (i == preorder.length) {
            return null;
        }
        int val = preorder[i];
        if (val > max) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        i++;
        node.left = insert(preorder, node.val);
        node.right = insert(preorder, max);
        return node;
    }

    // 解法3. 分治法
    public TreeNode bstFromPreorder(int[] preorder) {
        return partition(preorder, 0, preorder.length - 1);
    }

    private TreeNode partition(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        while (index <= end) {
            if (preorder[index] > preorder[start]) {
                break;
            }
            index++;
        }
        // index 就是右子树的起点
        root.left = partition(preorder, start + 1, index - 1);
        root.right = partition(preorder, index, end);
        return root;
    }

}
