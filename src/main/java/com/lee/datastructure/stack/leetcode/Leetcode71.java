package com.lee.datastructure.stack.leetcode;

import java.util.LinkedList;

/**
 * @description:
 * @author: LiJing
 * @date: 2025/2/15
 */
public class Leetcode71 {

    public static String simplifyPath01(String path) {
        String[] names = path.split("/"); // 空字符串  .  ..  目录名
        LinkedList<String> stack = new LinkedList<>();
        for (String name : names) {
            // .. 弹出栈顶的目录
            // 目录名 入栈
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.push(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        }
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append("/").append(stack.get(i));
        }
        return sb.toString();
    }

    // 优化
    public static String simplifyPath(String path) {
        String[] dirs = path.split("/");
        int index = 0;
        for (String dir : dirs) {
            if ("..".equals(dir)) {
                index = Math.max(0, index - 1);
            } else if (dir.length() > 0 && !".".equals(dir)) {
                dirs[index++] = dir;
            }
        }
        if (index == 0) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append("/").append(dirs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/.../a/../b///c/../d/./"));
        System.out.println(simplifyPath("/../"));
    }
}
