package com.lee.datastructure.linkedlist.leetcode;

/**
 * @description: 反转链表 II
 * @author: LiJing
 * @date: 2025/2/16
 */
public class Leetcode92 {
    /*
       node1 → node2 → node3 → node4 → node5 → node6 → ...
               o1       o2
               n1
     */

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }
        ListNode s = new ListNode(-1, head), pre = s;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode n1 = pre.next, o1 = pre.next, o2 = pre.next.next;
        for (int i = 0; i < right - left; i++) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        pre.next = n1;
        return s.next;
    }
}
