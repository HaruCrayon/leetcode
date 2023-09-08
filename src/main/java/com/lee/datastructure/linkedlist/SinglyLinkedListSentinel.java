package com.lee.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表(带哨兵)
 *
 * @author LiJing
 * @version 1.0
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    private Node head = new Node(666, null); // 头指针

    /**
     * 节点类
     */
    private static class Node {
        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加
     *
     * @param value 待添加值
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    /**
     * 遍历链表 while
     *
     * @param consumer 要执行的操作
     */
    public void loop1(Consumer<Integer> consumer) {
        Node curr = head.next;
        while (curr != null) {
            consumer.accept(curr.value);
            curr = curr.next;
        }
    }

    /**
     * 遍历链表 for
     *
     * @param consumer 要执行的操作
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node curr = head.next; curr != null; curr = curr.next) {
            consumer.accept(curr.value);
        }
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
            public boolean hasNext() { // 判断是否还有必要调用 next
                return curr != null;
            }

            @Override
            public Integer next() { // 返回当前节点的 value ; 指向下一个节点
                int v = curr.value;
                curr = curr.next;
                return v;
            }
        };
    }

    /**
     * 查找尾部节点
     *
     * @return
     */
    private Node findLast() {
        Node curr;
        for (curr = head; curr.next != null; curr = curr.next) {

        }
        return curr;
    }

    /**
     * 向链表尾部添加
     *
     * @param value 待添加值
     */
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    /**
     * 根据索引查找节点
     *
     * @param index 索引
     * @return
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node curr = head; curr != null; curr = curr.next, i++) {
            if (i == index) {
                return curr;
            }
        }
        return null; // 没找到
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    /**
     * 根据索引查找
     *
     * @param index 索引
     * @return 找到, 返回该索引位置节点的值
     * @throws IllegalArgumentException 找不到, 抛出 index 非法异常
     */
    public int get(int index) throws IllegalArgumentException {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    /**
     * 向索引位置插入
     *
     * @param index 索引
     * @param value 待插入值
     * @throws IllegalArgumentException 找不到, 抛出 index 非法异常
     */
    public void insert(int index, int value) throws IllegalArgumentException {
        Node prev = findNode(index - 1); // 查找上一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    /**
     * 删除第一个
     *
     * @throws IllegalArgumentException 如果链表为空, 抛出 index 非法异常
     */
    public void removeFirst() throws IllegalArgumentException {
        remove(0);
    }

    /**
     * 从索引位置删除
     *
     * @param index 索引
     * @throws IllegalArgumentException 找不到, 抛出 index 非法异常
     */
    public void remove(int index) throws IllegalArgumentException {
        Node prev = findNode(index - 1); // 上一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next; // 被删除的节点
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }
}
