package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树的右视图
 * @author: LiJing
 * @date: 2025/2/18
 */
public class Leetcode199 {

    public List<Integer> rightSideView01(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                if (i == 1) {
                    res.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int c1 = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int c2 = 0;
            for (int i = c1; i > 0; i--) {
                TreeNode poll = queue.poll();
                if (i == 1) {
                    res.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                    c2++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    c2++;
                }
            }
            c1 = c2;
        }
        return res;
    }
}
