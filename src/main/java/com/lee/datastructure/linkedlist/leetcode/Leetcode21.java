package com.lee.datastructure.linkedlist.leetcode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode21 {

    /*
        1. 谁小，把谁链给 p，p 和小的都向后平移一位
        2. 当 p1、p2 有一个为 null，退出循环，把不为 null 的链给 p

        p1
        1	3	8	9	null

        p2
        2	4	null

        p
        s	null
     */
    // 方法1
    public ListNode mergeTwoLists1(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(-1, null); // 哨兵节点
        ListNode p = s;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return s.next;
    }

    /*
        递归函数应该返回:
        1. 更小的那个链表节点，并把它剩余节点与另一个链表再次递归
        2. 返回之前，更新此节点的 next
     */
    // 方法2 - 递归
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if (p2 == null) {
            return p1;
        }
        if (p1 == null) {
            return p2;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwoLists(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoLists(p1, p2.next);
            return p2;
        }
    }

    public static void main(String[] args) {
        ListNode p1 = ListNode.of(1, 3, 8, 9, 10);
        ListNode p2 = ListNode.of(2, 2, 4);

        System.out.println(new Leetcode21().mergeTwoLists(p1, p2));
    }
}
