package com.lee.datastructure.linkedlist.leetcode;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head，请你判断该链表是否为回文链表。如果是，返回 true；否则，返回 false。
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode234 {

    /*
        步骤1. 找中间点的同时反转前半个链表
        步骤2. 反转后的前半个链表 与 中间点开始的后半个链表 逐一比较
                p1      p2
        1   2   2   1   null

        n1
        2   1

                o1
                p1      p2
        1   2   3   2   1   null

        n1
        2   1   null
     */

    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head; // 慢指针
        ListNode p2 = head; // 快指针
        ListNode n1 = null; // 新头
        ListNode o1 = head; // 旧头

        // 快慢指针找中间节点
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            // 反转前半部分
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
//        System.out.println("p1= " + p1);
//        System.out.println("n1= " + n1);

        if (p2 != null) { // 奇数个节点
            p1 = p1.next;
        }

        // 同步比较新头和后半部分
        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode234()
                .isPalindrome(ListNode.of(1, 2, 2, 1)));

        System.out.println(new Leetcode234()
                .isPalindrome(ListNode.of(1, 2, 3, 2, 1)));
    }
}
