package com.lee.datastructure.linkedlist.leetcode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode206 {
    /*
        构造一个新链表，从旧链表依次拿到每个节点，创建新节点添加至新链表头部，完成后新链表即是倒序的。
        简单直白，就是得新创建节点对象
     */
    // 方法1
    public ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    /*
        与方法1 类似，构造一个新链表，从旧链表头部移除节点，添加到新链表头部，完成后新链表即是倒序的。
        区别在于原题目未提供节点外层的容器类，这里提供一个，另外一个区别是并不去构造新节点
     */
    // 方法2
    public ListNode reverseList2(ListNode head) {
        List list_old = new List(head);
        List list_new = new List(null);
        while (true) {
            ListNode first = list_old.removeFirst();
            if (first == null) {
                break;
            }
            list_new.addFirst(first);
        }
        return list_new.head;
    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }
    }

    /*
        首先，写一个递归方法，返回值用来拿到最后一个节点
        递归，在归时让 5 -> 4, 4 -> 3, 3 -> 2 ...
     */
    // 方法3 - 递归
    public ListNode reverseList3(ListNode p) {
        if (p == null || p.next == null) {
            return p; // 最后节点
        }
        ListNode last = reverseList3(p.next);
        p.next.next = p;
        p.next = null;

        return last;
    }

    /*
        从链表每次拿到第二个节点，将其从链表断开，插入头部，直至它为 null 结束
        1. 设置指针 o1(旧头)、n1(新头)、o2(旧二)
        2. 将 o2 节点从链表断开，即 o1 节点指向第三节点
        3. o2 节点链入链表头部
        4. n1 指向 o2
        5. o2 指向 o1 的下一个节点
        6. 重复以上 2 ~ 5 步，直到 o2 指向 null
        7. 还应当考虑边界条件，即链表中不满两个元素时，无需走以上逻辑
     */
    // 方法4
    public ListNode reverseList4(ListNode o1) {
        if (o1 == null || o1.next == null) { // 1. 空链表  2. 一个元素
            return o1;
        }
        ListNode n1 = o1;
        ListNode o2 = o1.next;
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    /*
        把链表分成两部分，不断从链表2的头，往链表1的头搬移
        1. n1 指向 null，代表新链表一开始没有元素，o1 指向原链表的首节点
        2. 开始循环，o2 指向原链表次节点
        3. 搬移
        4. 指针复位
        5. 5. 重复 2 ~ 4 步
        6. 当 o1 = null 时退出循环
     */
    // 方法5
    public ListNode reverseList(ListNode o1) {
        if (o1 == null || o1.next == null) { // 1. 空链表  2. 一个元素
            return o1;
        }
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new Leetcode206().reverseList(o1);
        System.out.println(n1);
    }
}
