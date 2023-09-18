package com.lee.datastructure.stack.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode20 {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>(); // 栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /*
        (   [   ]

        底 - 栈 - 顶
        )

        遇到左括号, 把要配对的右括号放入栈顶
        遇到右括号, 把它与栈顶元素对比
            若相等, 栈顶元素弹出, 继续对比下一组
            若不等, 无效括号直接返回 false
     */

    public static void main(String[] args) {
        Leetcode20 s = new Leetcode20();
        System.out.println(s.isValid("([{}])"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("()"));
        System.out.println("---------------------");

        System.out.println(s.isValid("[)"));
        // ]
        System.out.println(s.isValid("([)]"));
        // ) ]
        System.out.println(s.isValid("([]"));
        // )
        System.out.println(s.isValid("("));

        System.out.println("---------------------");
        System.out.println(s.isValid(")("));
        System.out.println(s.isValid("]"));
    }

}
