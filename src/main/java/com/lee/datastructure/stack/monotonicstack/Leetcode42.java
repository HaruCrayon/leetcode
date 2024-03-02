package com.lee.datastructure.stack.monotonicstack;

import java.util.LinkedList;

/**
 * 42. 接雨水
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode42 {
    /*
        1. 维护一个单调栈
        2. 当加入一个新元素时，如果发现需要弹出元素，表示遇到了一个凹陷位置，此时应该计算雨水容量
     */

    public static int trap(int[] heights) {
        LinkedList<Data> stack = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            Data right = new Data(i, heights[i]); // 待加入的新元素
            while (!stack.isEmpty() && stack.peek().height < right.height) {
                Data pop = stack.pop(); // 需要弹出的元素
                Data left = stack.peek();
                if (left != null) { // 计算雨水的容量
                    int width = right.idx - left.idx - 1;
                    int height = Math.min(left.height, right.height) - pop.height;
                    sum += width * height;
                }
            }
            stack.push(right);
        }
        return sum;
    }

    static class Data {
        int idx; // 索引
        int height;

        public Data(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5})); // 9
    }
}
