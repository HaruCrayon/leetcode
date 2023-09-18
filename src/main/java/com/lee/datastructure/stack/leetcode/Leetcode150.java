package com.lee.datastructure.stack.leetcode;

import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值（后缀表达式求值）
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode150 {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>(); // 栈
        for (String t : tokens) {
            switch (t) {
                case "+": {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-": {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*": {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/": {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default: { // 数字
                    stack.push(Integer.parseInt(t));
                }
            }
        }
        return stack.pop();
    }

    /*
        |   |
        | 13|
        | 4 | 底
        _____

        "4","13","5","/","+"

        - 遇到数字压入栈
        - 遇到运算符, 就从栈弹出两个数字做运算, 将结果压入栈
        - 遍历结束, 栈中剩下的数字就是结果
     */
}
