package com.lee.datastructure.deque.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * <P>给你二叉树的根节点 root，返回其节点值的 锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。</P>
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>(); // 队列
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        boolean odd = true; // 奇数层
        while (!queue.isEmpty()) {
            int c2 = 0; // 统计下一层节点数
            LinkedList<Integer> level = new LinkedList<>(); // 双端队列, 保存当前层结果
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                if (odd) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
            odd = !odd;
        }
        return result;
    }

    /*
                  1
                 / \
                2   3
               /\   /\
              4  5 6  7
             /\
            8  9

              1
              3 2
              4 5 6 7
              9 8
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );

        List<List<Integer>> result = new Leetcode103().zigzagLevelOrder(root);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
