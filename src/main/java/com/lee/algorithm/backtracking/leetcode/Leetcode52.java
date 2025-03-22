package com.lee.algorithm.backtracking.leetcode;

/**
 * @description: N 皇后 II
 * @date: 2025/3/23
 */
public class Leetcode52 {
    private int count;

    public int totalNQueens(int n) {
        boolean[] column = new boolean[n]; // 记录列冲突 j
        boolean[] left = new boolean[2 * n - 1]; // 记录左斜线冲突  i+j
        boolean[] right = new boolean[2 * n - 1]; // 记录右斜线冲突 n-1-(i-j)
        dfs(0, n, column, left, right);
        return count;
    }

    private void dfs(int i, int n, boolean[] column, boolean[] left, boolean[] right) {
        if (i == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (column[j] || left[i + j] || right[n - 1 - (i - j)]) {
                continue;
            }
            column[j] = left[i + j] = right[n - 1 - (i - j)] = true;
            dfs(i + 1, n, column, left, right);
            column[j] = left[i + j] = right[n - 1 - (i - j)] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode52().totalNQueens(8));
    }
}
