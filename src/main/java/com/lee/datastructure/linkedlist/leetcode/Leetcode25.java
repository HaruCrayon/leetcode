package com.lee.datastructure.linkedlist.leetcode;

/**
 * @description: K个一组翻转链表
 * @author: LiJing
 * @date: 2025/2/17
 */
public class Leetcode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode pre = s;
        while (head != null) {
            ListNode tail = head;
            for (int i = 0; i < k - 1; i++) {
                tail = tail.next;
                if (tail == null) {
                    return s.next;
                }
            }
            ListNode nex = tail.next;
            pre.next = myReverse(head, tail);
            head.next = nex;
            pre = head;
            head = nex;
        }
        return s.next;
    }

    private ListNode myReverse(ListNode head, ListNode tail) {
        ListNode nex = tail.next;
        ListNode n1 = head, cur = head.next;
        while (cur != nex) {
            head.next = cur.next;
            cur.next = n1;
            n1 = cur;
            cur = head.next;
        }
        return n1;
    }
}
