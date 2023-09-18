package com.lee.datastructure.stack;

import java.util.LinkedList;

/**
 * 中缀表达式转后缀表达式
 *
 * @author LiJing
 * @version 1.0
 */
public class E01InfixToSuffix {
    /*
        |   |
        |   |
        |   |
        _____

        a+b             ab+
        a+b-c           ab+c-
        a*b+c           ab*c+
        a+b*c           abc*+
        a+b*c-d         abc*+d-
        (a+b)*c         ab+c*
        (a+b*c-d)*e     abc*+d-e*
        a*(b+c)         abc+*

        1. 遇到非运算符 直接拼串
        2. 遇到 + - * /
            - 它的优先级比栈顶运算符高, 入栈, 如: 栈中是 + 当前是 *
            - 否则把栈里优先级 >= 它 的都出栈, 它再入栈, 如: 栈中是 +*, 当前是 -
        3. 遍历完成, 栈里剩余运算符依次出栈
        4. 带()
            - 左括号直接入栈, 左括号优先设置为0
            - 右括号就把栈里到左括号为止的所有运算符出栈，再把左括号出栈
     */

    /**
     * @param exp 中缀表达式
     * @return 后缀表达式
     */
    public String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>(); // 栈
        StringBuilder sb = new StringBuilder(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '*':
                case '/':
                case '+':
                case '-': {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                    break;
                }
                case '(': {
                    stack.push(c);
                    break;
                }
                case ')': {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                }
                default: {
                    sb.append(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private int priority(char c) {
        int result;
        switch (c) {
            case '*':
            case '/': {
                result = 2;
                break;
            }
            case '+':
            case '-': {
                result = 1;
                break;
            }
            case '(': {
                result = 0;
                break;
            }
            default: {
                throw new IllegalArgumentException("不合法的运算符:" + c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        E01InfixToSuffix e01 = new E01InfixToSuffix();
        System.out.println(e01.infixToSuffix("a+b"));
        System.out.println(e01.infixToSuffix("a+b-c"));
        System.out.println(e01.infixToSuffix("a*b+c"));
        System.out.println(e01.infixToSuffix("a+b*c"));
        System.out.println(e01.infixToSuffix("a+b*c-d"));
        System.out.println(e01.infixToSuffix("(a+b)*c"));
        System.out.println(e01.infixToSuffix("(a+b*c-d)*e"));
        System.out.println(e01.infixToSuffix("a*(b+c)"));
    }

}
