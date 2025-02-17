package com.lee.datastructure.linkedlist.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 随机链表的复制
 * @author: LiJing
 * @date: 2025/2/15
 */
public class Leetcode138 {

    static class Solution {
        // 方法1：哈希表
        public Node copyRandomList01(Node head) {
            if (head == null) {
                return null;
            }
            // 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
            Map<Node, Node> map = new HashMap<>();
            Node cur = head;
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            // 设置各新节点的 next 和 random 指向
            cur = head;
            while (cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            // 返回新链表的头节点
            return map.get(head);
        }

        // 方法2：拼接 + 拆分
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            // 1. 复制各节点，并构建拼接链表
            // node1 → node1_new → node2 → node2_new → node3 → node3_new → ...
            Node cur = head;
            while (cur != null) {
                Node node = new Node(cur.val);
                node.next = cur.next;
                cur.next = node;
                cur = node.next;
            }
            // 2. 设置各新节点的 random 指向
            cur = head;
            while (cur != null) {
                if (cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            // 3. 拆分链表
            cur = head.next;
            Node pre = head, res = head.next;
            while (cur.next != null) {
                pre.next = pre.next.next;
                pre = pre.next;
                cur.next = cur.next.next;
                cur = cur.next;
            }
            pre.next = null;
            // 返回新链表头节点
            return res;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
