package com.lee.datastructure.heap;

import java.util.Arrays;

/**
 * 可以扩容的 heap, max 用于指定是大顶堆还是小顶堆
 */
public class Heap {
    private int[] array;
    private int size;
    private final boolean max;

    public Heap(int capacity, boolean max) {
        this.array = new int[capacity];
        this.max = max;
    }

    public Heap(int[] array, boolean max) {
        this.array = array;
        this.size = array.length;
        this.max = max;
        heapify();
    }

    public int[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    /**
     * 建堆
     * 1. 找到最后一个非叶子节点
     * 2. 从后向前，对每个节点执行下潜
     */
    private void heapify() {
        // 如何找到最后这个非叶子节点  size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    // 将 parent 索引处的元素下潜: 与两个孩子较大者交换, 直至没孩子或孩子没它大
    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int maxOrMin = parent;
        if (left < size && (max ? array[left] > array[maxOrMin] : array[left] < array[maxOrMin])) {
            maxOrMin = left;
        }
        if (right < size && (max ? array[right] > array[maxOrMin] : array[right] < array[maxOrMin])) {
            maxOrMin = right;
        }
        if (maxOrMin != parent) { // 找到了更大的孩子
            swap(maxOrMin, parent);
            down(maxOrMin);
        }
    }

    // 交换两个索引处的元素
    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * 获取堆顶元素
     *
     * @return 堆顶元素
     */
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    /**
     * 删除指定索引处元素
     *
     * @param index 索引
     * @return 被删除元素
     */
    public Integer poll(int index) {
        if (isEmpty() || index >= size) {
            return null;
        }
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced 新元素
     */
    public void replace(int replaced) {
        if (isEmpty()) {
            return;
        }
        array[0] = replaced;
        down(0);
    }

    /**
     * 堆的尾部添加元素
     *
     * @param offered 新元素
     */
    public void offer(int offered) {
        if (isFull()) {
            // 扩容
            grow();
        }
        up(offered);
        size++;
    }

    private void grow() {
        int capacity = size + (size >> 1);
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // 将 offered 元素上浮: 直至 offered 小于父元素或到堆顶
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            boolean cmp = max ? offered > array[parent] : offered < array[parent];
            if (cmp) {
                array[child] = array[parent];
                child = parent;
            } else {
                break;
            }
        }
        array[child] = offered;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }


    /*
              100
           /      \
          10      99
         / \      / \
        5   6    98 97
       /\   /\   /
      1 2  3  4 96

              100
           /      \
          96      99
         / \      / \
        10   6   98 97
       /\   /\
      1 2  3  4
     */
    public static void main(String[] args) {
        Heap heap = new Heap(5, true); //100,10,99,5,6,98,97,1,2,3,4,96
        heap.offer(100);
        heap.offer(10);
        heap.offer(99);
        heap.offer(5);
        heap.offer(6);
        heap.offer(98);
        heap.offer(97);
        heap.offer(1);
        heap.offer(2);
        heap.offer(3);
        heap.offer(4);
        heap.offer(96);
        System.out.println(heap);
        System.out.println(heap.getSize());
        System.out.println(heap.poll(3));
        System.out.println(heap);
        System.out.println(heap.getSize());
    }
}
