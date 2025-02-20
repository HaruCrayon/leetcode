package com.lee.datastructure.binarytree.leetcode;

/**
 * @description: 填充每个节点的下一个右侧节点指针 II
 * @author: LiJing
 * @date: 2025/2/20
 */
public class Leetcode117 {
    public Node connect(Node root) {
        Node cur = root; // 当前层的节点
        // 层序遍历
        while (cur != null) {
            Node sentinel = new Node(0); //下一层的虚拟头节点
            Node temp = sentinel; //当前处理的节点
            while (cur != null) {
                if (cur.left != null) {
                    temp.next = cur.left;
                    temp = temp.next;
                }
                if (cur.right != null) {
                    temp.next = cur.right;
                    temp = temp.next;
                }
                cur = cur.next;
            }
            cur = sentinel.next; // 移动到下一层的实际头节点处
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
