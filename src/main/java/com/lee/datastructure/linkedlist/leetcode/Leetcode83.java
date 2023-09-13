package com.lee.datastructure.linkedlist.leetcode;

/**
 * 83. 删除排序链表中的重复元素（重复元素保留一个）
 * 给定一个已排序的链表的头 head，删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表。
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode83 {

    // 方法1
    public ListNode deleteDuplicates1(ListNode head) {
        // 节点数 < 2
        if (head == null || head.next == null) {
            return head;
        }

        // 节点数 >= 2
        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                // 删除 p2
                p1.next = p2.next;
            } else {
                // 向后平移
                p1 = p1.next;
            }
        }
        return head;
    }

    /*
        递归函数负责返回：从当前节点（我）开始，完成去重的链表
        1. 若我与 next 重复，返回 next
        2. 若我与 next 不重复，返回我，但 next 应当更新
     */
    // 方法2 - 递归
    public ListNode deleteDuplicates(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            return deleteDuplicates(p.next);
        } else {
            p.next = deleteDuplicates(p.next);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 1, 2, 3, 3);
        System.out.println(head);
        System.out.println(new Leetcode83().deleteDuplicates(head));
    }
}
