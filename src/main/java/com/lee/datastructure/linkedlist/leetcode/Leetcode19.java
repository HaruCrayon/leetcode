package com.lee.datastructure.linkedlist.leetcode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode19 {

    // 方法1 - 递归
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode s = new ListNode(-1, head); // 哨兵节点
        recursion(s, n);
        return s.next;
    }

    /**
     * 递归函数
     *
     * @param p 当前节点
     * @param n
     * @return 当前节点的倒数序号
     */
    private int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        int nth = recursion(p.next, n); // 下一个节点的倒数序号
        if (nth == n) {
            p.next = p.next.next;
        }
        return nth + 1;
    }

    /*
        快慢指针，p1 指向待删节点的上一个，p2 先走 n + 1 步

        n=2
        p1
        p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

                  p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

        p1             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

                       p1             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
     */
    // 方法2
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1, head); // 哨兵节点
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
//        ListNode head = ListNode.of(1, 2);
        System.out.println(head);
        System.out.println(new Leetcode19().removeNthFromEnd(head, 2));
    }
}
