package com.lee.datastructure.binarytree;

import java.util.LinkedList;

/**
 * 二叉树-前中后遍历-非递归实现
 */
public class TreeTraversal02 {

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

        treeTraversal(root);
    }

    public static void treeTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root; // 代表当前节点
        TreeNode pop = null; // 最近一次弹栈的元素

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                // 待处理左子树
                colorPrintln("前:" + curr.val, 31);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null) {
                    colorPrintln("中:" + peek.val, 36);
                    pop = stack.pop();
                    colorPrintln("后:" + pop.val, 34);
                }
                // 右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
                    colorPrintln("后:" + pop.val, 34);
                }
                // 待处理右子树
                else {
                    colorPrintln("中:" + peek.val, 36);
                    curr = peek.right;
                }
            }
        }
    }

    /*
        31 红
        32 黄
        33 橙
        34 蓝
        35 紫
        36 绿
     */
    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}
