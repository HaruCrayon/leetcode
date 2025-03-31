package com.lee.datastructure.binarytree;

import java.util.LinkedList;

/**
 * 二叉树-前中后遍历-非递归实现
 */
public class TreeTraversal02_1 {

    public static void main(String[] args) {
        /*
                  1
               /    \
              2      3
             / \    / \
            4   5  6   7
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(5)),
                1,
                new TreeNode(new TreeNode(6), 3, new TreeNode(7))
        );

        preOrder(root);
        inOrder(root);
        postOrder(root);
    }

    // 前序遍历
    public static void preOrder(TreeNode root) {
        System.out.print("前序遍历: ");
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root; // 当前节点
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                System.out.print(curr.val + "\t");
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
        System.out.println();
    }

    // 中序遍历
    public static void inOrder(TreeNode root) {
        System.out.print("中序遍历: ");
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root; // 当前节点
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.print(pop.val + "\t");
                curr = pop.right;
            }
        }
        System.out.println();
    }

    // 后序遍历
    public static void postOrder(TreeNode root) {
        System.out.print("后序遍历: ");
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root; // 当前节点
        TreeNode pop = null;  // 最近一次弹栈的元素
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) { // 右子树处理完成
                    pop = stack.pop();
                    System.out.print(pop.val + "\t");
                } else {
                    curr = peek.right;
                }
            }
        }
        System.out.println();
    }

}
