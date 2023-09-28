package com.lee.datastructure.heap.leetcode;

import com.lee.datastructure.heap.MinHeap;

/**
 * 703. 数据流中的第 K 大元素
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode703 {
    private final MinHeap heap;

    public Leetcode703(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    // 此方法会被不断调用, 模拟数据流中新来的元素
    public int add(int val) {
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.replace(val);
        }

        return heap.peek();
    }

    // 测试
    public static void main(String[] args) {
        Leetcode703 test = new Leetcode703(3, new int[]{}); // []

        System.out.println(test.add(3)); // [3] 3
        System.out.println(test.add(5)); // [3 5] 3
        System.out.println(test.add(10)); // [3 5 10] 3
        System.out.println(test.add(9)); // [5 9 10] 5
        System.out.println(test.add(4)); // [5 9 10] 5

        System.out.println("---------------------------");

        test = new Leetcode703(3, new int[]{4, 5, 8, 2}); // [4, 5, 8]

        System.out.println(test.add(3)); // [4, 5, 8] 4
        System.out.println(test.add(5)); // [5, 5, 8] 5
        System.out.println(test.add(10)); // [5 8 10] 5
        System.out.println(test.add(9)); // [8 9 10] 8
        System.out.println(test.add(4)); // [8 9 10] 8
    }
}
