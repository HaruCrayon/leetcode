package com.lee.datastructure.binarysearchtree.leetcode;

import java.util.LinkedList;

/**
 * @description: 二叉搜索树的最小绝对差
 * @author: LiJing
 * @date: 2025/2/21
 */
public class Leetcode530 {

    // 题目中：0 <= Node.val <= 10^5

    // 方法1：递归
    private int ans = 100001, pre = -100001;

    public int getMinimumDifference01(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        ans = Math.min(ans, node.val - pre);
        if (ans == 1) {
            return;
        }
        pre = node.val;
        dfs(node.right);
    }

    // 方法2：非递归
    public int getMinimumDifference02(TreeNode root) {
        int res = 100001, pre = -100001;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res = Math.min(res, cur.val - pre);
            if (res == 1) {
                return res;
            }
            pre = cur.val;
            cur = cur.right;
        }
        return res;
    }
}
