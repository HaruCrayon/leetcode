package com.lee.datastructure.binarysearchtree.leetcode;

import java.util.LinkedList;

/**
 * @description: 二叉搜索树中第 K 小的元素
 * @author: LiJing
 * @date: 2025/2/21
 */
public class Leetcode230 {

    // 方法1：递归
    private int res, k;

    public int kthSmallest01(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (--k == 0) {
            res = node.val;
            return;
        }
        dfs(node.right);
    }

    // 方法2：非递归
    public int kthSmallest02(TreeNode root, int k) {
        int cnt = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cnt++;
            if (cnt == k) {
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }
}
