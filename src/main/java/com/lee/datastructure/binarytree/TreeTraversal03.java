package com.lee.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树-层序遍历(广度优先遍历)
 */
public class TreeTraversal03 {

    /*
                  1
               /    \
              2      3
             / \      \
            4   5      6
               /
              7
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),
                        2,
                        new TreeNode(new TreeNode(7), 5, null)
                ),
                1,
                new TreeNode(null, 3, new TreeNode(6)));

        breadthFirstOrder(root);
    }

    public static void breadthFirstOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll.val + "\t");
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            System.out.println();
        }
    }
}
