package com.lee.datastructure.linkedlist.leetcode;

/**
 * @description: 两数相加
 * @author: LiJing
 * @date: 2025/2/15
 */
public class Leetcode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            p.next = new ListNode(sum % 10, null);
            p = p.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            p.next = new ListNode(1, null);
        }
        return s.next;
    }
}
