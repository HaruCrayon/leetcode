package com.lee.datastructure.queue;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * 以单向环形带哨兵链表方式来实现队列
 *
 * @author LiJing
 * @version 1.0
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    /*
        节点类
     */
    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private final Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;
    private int size = 0;
    private int capacity = Integer.MAX_VALUE;

    {
        tail.next = head;
    }

    public LinkedListQueue() {
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 向队列尾插入值. 有的习惯命名为 enqueue
     *
     * @param value 待插入值
     * @return 插入成功返回 true, 插入失败返回 false
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    /**
     * 从队列头获取值, 并移除. 有的习惯命名为 dequeue
     *
     * @return 如果队列非空返回队头值, 否则返回 null
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        if (first == tail) {
            tail = head;
        }
        size--;
        return first.value;
    }

    /**
     * 从队列头获取值, 不移除
     *
     * @return 如果队列非空返回对头值, 否则返回 null
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    /**
     * 检查队列是否为空
     *
     * @return 空返回 true, 否则返回 false
     */
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 检查队列是否已满
     *
     * @return 满返回 true, 否则返回 false
     */
    @Override
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        for (E e : this) {
            sj.add(e.toString());
        }
        return sj.toString();
    }
}
