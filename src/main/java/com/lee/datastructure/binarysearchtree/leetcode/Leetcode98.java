package com.lee.datastructure.binarysearchtree.leetcode;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 98. 验证二叉搜索树
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode98 {

    // 解法1. 中序遍历非递归实现 1ms
    public boolean isValidBST1(TreeNode root) {
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE; // 代表上一个值
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理值
                if (prev >= pop.val) {
                    return false;
                }
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }

    // 解法2. 中序遍历递归实现(全局变量记录 prev) 0ms
    long prev = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean a = isValidBST2(node.left);
        if (!a) {
            return false;
        }
        if (prev >= node.val) {
            return false;
        }
        prev = node.val;
        return isValidBST2(node.right);
    }

    // 解法3. 中序遍历递归实现(局部变量记录 prev) 0ms
    public boolean isValidBST3(TreeNode node) {
        return doValid3(node, new AtomicLong(Long.MIN_VALUE));
    }

    private boolean doValid3(TreeNode node, AtomicLong prev) {
        if (node == null) {
            return true;
        }
        boolean a = doValid3(node.left, prev);
        if (!a) {
            return false;
        }
        if (prev.get() >= node.val) {
            return false;
        }
        prev.set(node.val);
        return doValid3(node.right, prev);
    }

    /*
              -∞ 4 +∞
               /   \
           -∞ 2  4  6 +∞
                   / \
                4 3 6 7 +∞
     */
    // 解法4. 上下限递归实现 0ms
    public boolean isValidBST4(TreeNode node) {
        return doValid4(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doValid4(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return doValid4(node.left, min, node.val) && doValid4(node.right, node.val, max);
    }

}
