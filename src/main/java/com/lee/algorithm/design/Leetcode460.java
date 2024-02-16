package com.lee.algorithm.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU 缓存
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode460 {

    static class LFUCache {

        private final Map<Integer, Node> kvMap = new HashMap<>();
        private final Map<Integer, DoublyLinkedList> freqMap = new HashMap<>();
        private final int capacity;
        private int minFreq = 1; // 最小频度

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        /*
            key 不存在
                返回 -1
            key 存在
                返回 value 值
                增加节点的使用频度，将其转移到频度+1的链表当中
         */
        public int get(int key) {
            if (!kvMap.containsKey(key)) {
                return -1;
            }
            Node node = kvMap.get(key);
            DoublyLinkedList list = freqMap.get(node.freq);
            list.remove(node);
            if (list.isEmpty() && minFreq == node.freq) {
                minFreq++;
            }
            node.freq++;
            freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addFirst(node);
            return node.value;
        }

        /*
            更新
                将节点的 value 更新，增加节点的使用频度，将其转移到频度+1的链表当中
            新增
                检查是否超过容量，若超过，淘汰 minFreq 链表的最后节点
                创建新节点，放入 kvMap，并加入频度为 1 的双向链表
         */
        public void put(int key, int value) {
            if (kvMap.containsKey(key)) { // 更新
                Node node = kvMap.get(key);
                node.value = value;
                DoublyLinkedList list = freqMap.get(node.freq);
                list.remove(node);
                if (list.isEmpty() && minFreq == node.freq) {
                    minFreq++;
                }
                node.freq++;
                freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addFirst(node);
            } else { // 新增
                if (kvMap.size() == capacity) {
                    Node node = freqMap.get(minFreq).removeLast();
                    kvMap.remove(node.key);
                }
                Node node = new Node(key, value);
                kvMap.put(key, node);
                freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirst(node);
                minFreq = 1;
            }
        }

        // 节点类
        static class Node {
            private int key;
            private int value;
            private int freq = 1; // 频度
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
            private int size;

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
                size++;
            }

            // 删除指定节点
            private void remove(Node node) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                size--;
            }

            // 尾部删除
            private Node removeLast() {
                Node last = tail.prev;
                remove(last);
                return last;
            }

            private boolean isEmpty() {
                return size == 0;
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1 freq=2
        cache.put(3, 3);
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 3 freq=2
        cache.put(4, 4);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3  freq=3
        System.out.println(cache.get(4)); // 4  freq=2

    }
}
