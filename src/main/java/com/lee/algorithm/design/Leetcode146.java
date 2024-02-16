package com.lee.algorithm.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode146 {

    static class LRUCache {

        private final Map<Integer, Node> map = new HashMap<>();
        private final DoublyLinkedList list = new DoublyLinkedList();
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) { // 更新
                Node node = map.get(key);
                node.value = value;
                list.remove(node);
                list.addFirst(node);
            } else { // 新增
                Node node = new Node(key, value);
                map.put(key, node);
                list.addFirst(node);
                if (map.size() > capacity) {
                    Node removed = list.removeLast();
                    map.remove(removed.key);
                }
            }
        }

        // 节点类
        static class Node {
            private int key;
            private int value;
            private Node prev;
            private Node next;

            private Node() {
            }

            private Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 双向链表类
        static class DoublyLinkedList {
            private final Node head;
            private final Node tail;

            private DoublyLinkedList() {
                head = tail = new Node();
                head.next = tail;
                tail.prev = head;
            }

            // 头部添加
            private void addFirst(Node newFirst) {
                Node oldFirst = head.next;
                newFirst.prev = head;
                newFirst.next = oldFirst;
                head.next = newFirst;
                oldFirst.prev = newFirst;
            }

            // 删除指定节点
            private void remove(Node node) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }

            // 尾部删除
            private Node removeLast() {
                Node last = tail.prev;
                remove(last);
                return last;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3);
        System.out.println(cache.get(2)); // -1
        cache.put(4, 4);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
