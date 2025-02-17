package com.lee.datastructure.linkedlist.leetcode;

/**
 * @description: 分隔链表
 * @author: LiJing
 * @date: 2025/2/17
 */
public class Leetcode86 {

    // 方法1
    public ListNode partition01(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-201, head);
        ListNode cur = head, n1 = s, pre = s;
        while (cur != null) {
            if (cur.val < x) {
                pre.next = cur.next;
                cur.next = n1.next;
                n1.next = cur;
                n1 = cur;
                pre = cur;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return s.next;
    }

    // 方法2
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-201, null);
        ListNode small = smallHead;
        ListNode bigHead = new ListNode(-201, null);
        ListNode big = bigHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                big.next = cur;
                big = big.next;
            }
            cur = cur.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }
}
