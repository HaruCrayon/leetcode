package com.lee.algorithm.design;

import java.util.Random;

/**
 * 1206. 设计跳表
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode1206 {

    static class Skiplist {

        private static final int MAX = 10;
        private final Node head = new Node(-1);

        static class Node {
            int val; // 值
            Node[] next = new Node[MAX]; // next 数组

            public Node(int val) {
                this.val = val;
            }
        }

        public Skiplist() {

        }

        /*
            设计一个方法，方法会随机返回 1~max 的数字
            从 1 开始，数字的几率逐级减半，例如 max = 4，让大概
                - 50% 的几率返回 1
                - 25% 的几率返回 2
                - 12.5% 的几率返回 3
                - 12.5% 的几率返回 4
         */
        private final Random r = new Random();

        private int randomLevel(int max) {
            int x = 1;
            while (x < max) {
                if (r.nextBoolean()) {
                    return x;
                }
                x++;
            }
            return x;
        }

        /*
            下楼梯规则
                - 若 next 指针为 null，或者 next 指向的节点值 >= 目标，向下找
                - 若 next 指针不为 null，且 next 指向的节点值 < 目标，向右找
         */
        private Node[] find(int val) {
            Node[] path = new Node[MAX];
            Node curr = head;
            for (int level = MAX - 1; level >= 0; level--) { // 从上向下找
                while (curr.next[level] != null && curr.next[level].val < val) { // 向右找
                    curr = curr.next[level];
                }
                path[level] = curr;
            }
            return path;
        }

        public boolean search(int target) {
            Node[] path = find(target);
            Node node = path[0].next[0];
            return node != null && node.val == target;
        }

        public void add(int num) {
            // 1. 确定添加位置（把 num 当作目标查询，经历的路径就可以确定添加位置）
            Node[] path = find(num);
            // 2. 创建新节点随机高度
            Node node = new Node(num);
            int level = randomLevel(MAX);
            // 3. 修改路径节点 next 指针，以及新节点 next 指针
            for (int i = 0; i < level; i++) {
                node.next[i] = path[i].next[i];
                path[i].next[i] = node;
            }
        }

        public boolean erase(int num) {
            Node[] path = find(num);
            Node node = path[0].next[0];
            if (node == null || node.val != num) {
                return false;
            }
            for (int i = 0; i < MAX; i++) {
                if (path[i].next[i] != node) {
                    break;
                }
                path[i].next[i] = node.next[i];
            }
            return true;
        }
    }

}
