package com.lee.datastructure.linkedlist.leetcode;

/**
 * @description: 旋转链表
 * @author: LiJing
 * @date: 2025/2/16
 */
public class Leetcode61 {

    // 方法1：递归
    public ListNode rotateRight01(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        return recursion(head, head, k, new int[]{0, 0});
    }

    private ListNode recursion(ListNode head, ListNode node, int k, int[] arr) {
        arr[0] += 1; // 统计节点总数
        if (node.next == null) {
            if (k % arr[0] == 0) {
                return head;
            }
            node.next = head;
            return null;
        }
        ListNode res = recursion(head, node.next, k, arr);
        arr[1] += 1; // 当前节点位置：倒数第几位
        if (k % arr[0] == arr[1]) {
            ListNode resNode = node.next;
            node.next = null;
            return resNode;
        }
        return res;
    }

    // 方法2：
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }
        if (k % n == 0) {
            return head;
        }
        cur.next = head;
        int add = n - k % n;
        while (add-- > 0) {
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }
}
