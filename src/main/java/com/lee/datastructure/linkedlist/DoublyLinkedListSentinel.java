package com.lee.datastructure.linkedlist;

import java.util.Iterator;

/**
 * 双向链表(带哨兵)
 *
 * @author LiJing
 * @version 1.0
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {

    /**
     * 节点类
     */
    private static class Node {
        Node prev; // 上一个节点指针
        int value; // 值
        Node next; // 下一个节点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head; // 头哨兵
    private Node tail; // 尾哨兵

    public DoublyLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.prev = head;
    }

    public Node findNode(int index) {
        int i = -1;
        for (Node curr = head; curr != tail; curr = curr.next, i++) {
            if (i == index) {
                return curr;
            }
        }
        return null;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            throw illegalIndex(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void remove(int index) {
        Node removed = findNode(index);
        if (removed == null || removed == head) {
            throw illegalIndex(index);
        }
        Node prev = removed.prev;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node curr = head.next;

            @Override
            public boolean hasNext() {
                return curr != tail;
            }

            @Override
            public Integer next() {
                int value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }
}
