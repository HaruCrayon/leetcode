package com.lee.datastructure.heap.leetcode;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * <p>使用 PriorityQueue 实现</p>
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode295_2 {

    // 大顶堆
    private final PriorityQueue<Integer> left = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
    );
    // 小顶堆
    private final PriorityQueue<Integer> right = new PriorityQueue<>();

    /**
     * 为了保证两边数据量的平衡
     * <ul>
     * <li>两边个数一样时,左边个数加一</li>
     * <li>两边个数不一样时,右边个数加一</li>
     * </ul>
     * 但是, 随便一个数能直接加入吗?
     * <ul>
     * <li>左边个数加一时, 把新元素加在右边，弹出右边最小的加入左边</li>
     * <li>右边个数加一时, 把新元素加在左边，弹出左边最小的加入右边</li>
     * </ul>
     */
    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    /**
     * <ul>
     *     <li>两边数据一致, 左右各取堆顶元素求平均</li>
     *     <li>左边多一个, 取左边堆顶元素</li>
     * </ul>
     */
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    // 测试
    public static void main(String[] args) {
        Leetcode295_2 test = new Leetcode295_2();
        test.addNum(1);
        test.addNum(2);
        test.addNum(3);
        test.addNum(7);
        test.addNum(8);
        test.addNum(9);
        System.out.println(test.findMedian());
        test.addNum(10);
        System.out.println(test.findMedian());
        test.addNum(4);
        System.out.println(test.findMedian());
    }
}
