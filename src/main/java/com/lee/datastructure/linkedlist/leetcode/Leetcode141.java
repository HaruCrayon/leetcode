package com.lee.datastructure.linkedlist.leetcode;

/**
 * 141. 环形链表 - 检测链表是否有环
 * 给你一个链表的头节点 head ，判断链表中是否有环。如果链表中存在环，则返回 true。否则，返回 false。
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode141 {

    /**
     * <h3>Floyd 判环算法：Floyd's Tortoise and Hare Algorithm （Floyd 龟兔赛跑算法）</h3>
     * <p>如果链表上存在环，那么在环上以不同速度前进的两个指针必定会在某个时刻相遇。算法分为两个阶段</p>
     *
     * <p>阶段1</p>
     * <p>龟一次走一步，兔子一次走两步</p>
     * <p>当兔子能走到终点时，不存在环</p>
     * <p>当兔子能追上龟时，可以判断存在环</p>
     *
     * <p>阶段2</p>
     * <p>从它们第一次相遇开始，龟回到起点，兔子保持原位不变</p>
     * <p>龟和兔子一次都走一步</p>
     * <p>当再次相遇时，地点就是环的入口</p>
     */

    public boolean hasCycle(ListNode head) {
        ListNode h = head; // 兔
        ListNode t = head; // 龟
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
            if (h == t) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 构造一个带环链表
        ListNode n12 = new ListNode(12, null);
        ListNode n11 = new ListNode(11, n12);
        ListNode n10 = new ListNode(10, n11);
        ListNode n9 = new ListNode(9, n10);
        ListNode n8 = new ListNode(8, n9);
        ListNode n7 = new ListNode(7, n8);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        n12.next = n8;

        System.out.println(new Leetcode141().hasCycle(n1));
    }
}
