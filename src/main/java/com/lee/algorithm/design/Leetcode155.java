package com.lee.algorithm.design;

import java.util.LinkedList;

/**
 * 155. 最小栈
 *
 * @author LiJing
 * @version 1.0
 */
@SuppressWarnings("all")
public class Leetcode155 {

    // 解法一
    static class MinStack {

        private final LinkedList<Integer> stack = new LinkedList<>();
        private final LinkedList<Integer> min = new LinkedList<>();

        public MinStack() {
            min.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            min.push(Math.min(val, min.peek()));
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    // 解法二
    static class MinStack2 {

        private final LinkedList<Data> stack = new LinkedList<>();

        static class Data {
            private int val;
            private int min;

            private Data(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        public MinStack2() {

        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Data(val, val));
            } else {
                stack.push(new Data(val, Math.min(val, stack.peek().min)));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }

}
