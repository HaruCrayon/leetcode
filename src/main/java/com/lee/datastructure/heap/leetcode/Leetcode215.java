package com.lee.datastructure.heap.leetcode;

import com.lee.datastructure.heap.MinHeap;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第 K 个最大元素
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode215 {

    /**
     * <h3>求数组中第 K 大的元素 - 小顶堆</h3>
     * <p>
     * 思路
     * <ol>
     *     <li>向小顶堆放入前k个元素</li>
     *     <li>剩余元素</li>
     *     <ul>
     *         <li>若 <= 堆顶元素, 则略过</li>
     *         <li>若 > 堆顶元素, 则替换堆顶元素</li>
     *     </ul>
     *     <li>这样小顶堆始终保留的是到目前为止, <b>前 K 大</b>的元素</li>
     *     <li>循环结束, 堆顶元素即为<b>第 K 大</b>元素</li>
     *     <li>时间复杂度 O(n*log(n))</li>
     * </ol>
     */
    public int findKthLargest2(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.replace(nums[i]);
            }
        }

        return heap.peek();
    }

    // 使用Java优先级队列当作小顶堆
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        Leetcode215 code = new Leetcode215();
        System.out.println(code.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(code.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
    }
}
