package com.lee.datastructure.linkedlist.leetcode;

/**
 * 82. 删除排序链表中的重复元素（重复元素一个不留）
 * 给定一个已排序的链表的头 head，删除原始链表中所有重复数字的节点，只留下不同的数字。返回 已排序的链表。
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode82 {

    /*
        递归函数负责返回：从当前节点（我）开始，完成去重的链表
        1. 若我与 next 重复，一直找到下一个不重复的节点，以它的返回结果为准
        2. 若我与 next 不重复，返回我，同时更新 next
     */
    // 方法1 - 递归
    public ListNode deleteDuplicates1(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            // x 就是与 p 取值不同的节点
            return deleteDuplicates1(x);
        } else {
            p.next = deleteDuplicates1(p.next);
            return p;
        }
    }

    /*
        p1 是待删除的上一个节点，每次循环对比 p2、p3 的值
        1. 如果 p2 与 p3 的值重复，那么 p3 继续后移，直到找到与 p2 不重复的节点，p1 指向 p3 完成删除
        2. 如果 p2 与 p3 的值不重复，p1，p2，p3 向后平移一位，继续上面的操作
        3. p2 或 p3 为 null 退出循环

        p1 p2 p3
        s, 1, 1, 1, 2, 3, null

        p1 p2    p3
        s, 1, 1, 1, 2, 3, null

        p1 p2       p3
        s, 1, 1, 1, 2, 3, null

        p1 p3
        s, 2, 3, null

        p1 p2 p3
        s, 2, 3, null

           p1 p2 p3
        s, 2, 3, null
     */
    // 方法2
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head); // 哨兵节点
        ListNode p1 = s;
        ListNode p2, p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null && p3.val == p2.val) {
                }
                // 此时 p3 找到与 p2 不重复的节点
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 3, 4, 4, 5);
//        ListNode head = ListNode.of(1, 1, 1, 2, 3);
//        ListNode head = ListNode.of(1, 1, 1);
        System.out.println(head);
        System.out.println(new Leetcode82().deleteDuplicates(head));
    }
}
