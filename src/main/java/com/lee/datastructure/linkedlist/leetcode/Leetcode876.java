package com.lee.datastructure.linkedlist.leetcode;

/**
 * 876. 链表的中间节点
 * 给你单链表的头节点 head，请你找出并返回链表的中间节点。
 * 如果有两个中间节点，则返回第二个中间节点。
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode876 {

    /*
        快慢指针，快指针一次走两步，慢指针一次走一步，当快指针到链表结尾时，慢指针恰好走到链表的一半
                p1
                        p2
        1   2   3   4   5   null

                    p1
                                p2
        1   2   3   4   5   6   null
     */

    /**
     * @param head 头节点
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head; // 慢指针
        ListNode p2 = head; // 快指针
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(new Leetcode876().middleNode(head1));

        ListNode head2 = ListNode.of(1, 2, 3, 4, 5, 6);
        System.out.println(new Leetcode876().middleNode(head2));
    }
}
