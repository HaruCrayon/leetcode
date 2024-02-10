package com.lee.datastructure.monotonicqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode239 {

    // 每次向单调递减队列加入元素，队头元素即为滑动窗口最大值
    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 检查队列头部元素，超过滑动窗口范围要移除
            if (i >= k && queue.peekFirst() == nums[i - k]) {
                queue.pollFirst();
            }
            int num = nums[i];
            while (!queue.isEmpty() && queue.peekLast() < num) {
                queue.pollLast();
            }
            queue.offerLast(num);
            if (i >= (k - 1)) {
                list.add(queue.peekFirst());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, -4, 5, 3, 6, 7}, 3)));
    }
}
