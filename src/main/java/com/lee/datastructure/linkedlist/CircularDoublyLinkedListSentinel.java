package com.lee.datastructure.linkedlist;

import java.util.Iterator;

/**
 * 双向环形链表(带哨兵)
 *
 * @author LiJing
 * @version 1.0
 */
public class CircularDoublyLinkedListSentinel implements Iterable<Integer> {

    /**
     * 节点类
     */
    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, 666, null);

    public CircularDoublyLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    /**
     * 根据值删除
     *
     * @param value 目标值
     */
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            return; // 不用删
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    private Node findByValue(int value) {
        Node curr = sentinel.next;
        while (curr != sentinel) {
            if (curr.value == value) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node curr = sentinel.next;

            @Override
            public boolean hasNext() {
                return curr != sentinel;
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
