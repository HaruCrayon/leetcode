package com.lee.datastructure.heap;

import java.util.Arrays;

/**
 * 堆排序
 */
public class E01HeapSort {
    /*
        算法描述
        1. heapify 建立大顶堆
        2. 将堆顶与堆底交换（最大元素被交换到堆底），缩小并下潜调整堆
        3. 重复第二步直至堆里剩一个元素
     */

    public static void sort(int[] array) {
        // 1. 建堆
        MaxHeap maxHeap = new MaxHeap(array);
        while (maxHeap.size > 1) {
            // 2. 将堆顶元素交换至堆底
            maxHeap.swap(0, maxHeap.size - 1);
            // 堆大小减一
            maxHeap.size--;
            // 重新调整堆
            maxHeap.down(0);
        }
    }

    // 测试
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 7, 6, 4, 5};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
