package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @description: 二叉搜索树迭代器
 * @author: LiJing
 * @date: 2025/2/20
 */
public class Leetcode173 {

    static class BSTIterator {
        LinkedList<TreeNode> stack;
        TreeNode curr;

        public BSTIterator(TreeNode root) {
            stack = new LinkedList<>();
            curr = root;
        }

        public int next() {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            int res = curr.val;
            curr = curr.right;
            return res;
        }

        public boolean hasNext() {
            return curr != null || !stack.isEmpty();
        }
    }
}
