package com.lee.datastructure.linkedlist.leetcode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode203 {

    /**
     * 方法1
     *
     * @param head 链表头
     * @param val  目标值
     * @return 删除目标值后的链表头
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode s = new ListNode(-1, head); // 哨兵节点
        ListNode p1 = s;
        ListNode p2 = p1.next;
        while (p2 != null) {
            if (p2.val == val) {
                // 删除， p2 向后平移
                p1.next = p2.next;
            } else {
                // p1 p2 向后平移
                p1 = p1.next;
            }
            p2 = p1.next;
        }
        return s.next;
    }

    /**
     * 方法2 - 递归
     * 递归函数负责返回：从当前节点（我）开始，完成删除的子链表
     *
     * @param p   链表头
     * @param val 目标值
     * @return 删除目标值后的链表头
     */
    public ListNode removeElements(ListNode p, int val) {
        if (p == null) {
            return null;
        }
        if (p.val == val) {
            // 若我与 val 相等，应该返回下一个节点递归结果
            return removeElements(p.next, val);
        } else {
            // 若我与 val 不等，应该返回我，但我的 next 应该更新（让我能带上后续删过的子链表）
            p.next = removeElements(p.next, val);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 6, 3, 6);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new Leetcode203().removeElements(head, 6));
    }
}
