package com.lee.datastructure.priorityqueue.leetcode;

import com.lee.datastructure.linkedlist.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode23 {
    /*
        升序链表
        1->4->5->null
        1->3->4->null
        2->6->null

        小顶堆
            1 2 4
        新链表
            s->1
     */

    // 使用自定义小顶堆实现
    public ListNode mergeKLists1(ListNode[] lists) {
        MinHeap heap = new MinHeap(lists.length);
        // 1. 将链表的头节点加入小顶堆
        for (ListNode h : lists) {
            if (h != null) {
                heap.offer(h);
            }
        }
        // 2. 不断从堆顶移除最小元素, 加入新链表
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            t.next = min;
            t = min;
            // 将最小元素的下一个节点加入到堆
            if (min.next != null) {
                heap.offer(min.next);
            }
        }
        return s.next;
    }

    // 使用 jdk 的优先级队列实现
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        // 1. 将链表的头节点加入队列
        for (ListNode h : lists) {
            if (h != null) {
                queue.offer(h);
            }
        }
        // 2. 不断从队列移除最小元素, 加入新链表
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            t.next = min;
            t = min;
            // 将最小元素的下一个节点加入到队列
            if (min.next != null) {
                queue.offer(min.next);
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6),
                null,
        };
        ListNode m = new Leetcode23().mergeKLists(lists);
        System.out.println(m);
    }
}
