package com.lee.datastructure.stack.leetcode;

import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode232 {

    /*
        队列头        队列尾
        b
        顶   底     底   顶
        s1              s2

        队列尾添加
            s2.push(a)
            s2.push(b)

        队列头移除
            先把 s2 的所有元素移动到 s1
            s1.pop()
     */

    private LinkedList<Integer> s1 = new LinkedList<>(); // 栈 1
    private LinkedList<Integer> s2 = new LinkedList<>(); // 栈 2

    public void push(int x) { // 向队列尾添加
        s2.push(x);
    }

    public int pop() { // 从对列头移除
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek() { // 从对列头获取
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
