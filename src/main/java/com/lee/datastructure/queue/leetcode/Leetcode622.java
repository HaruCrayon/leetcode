package com.lee.datastructure.queue.leetcode;

/**
 * 622. 设计循环队列
 * 实现队列，基于数组(未考虑正整数越界)
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode622 {

    private final int[] array;
    private final int capacity;
    private int head = 0;
    private int tail = 0;

    public Leetcode622(int capacity) {
        this.capacity = capacity;
        array = new int[this.capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[tail % capacity] = value;
        tail++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[head % capacity];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(tail - 1) % capacity];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail - head == capacity;
    }

    public static void main(String[] args) {
        Leetcode622 queue = new Leetcode622(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        queue.deQueue();
        queue.enQueue(4);
        System.out.println(queue.Front());
        System.out.println(queue.Rear());
    }
}
