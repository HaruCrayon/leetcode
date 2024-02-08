package com.lee.algorithm.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode51 {

    public List<List<String>> solveNQueens(int n) {
        boolean[] column = new boolean[n]; // 记录列冲突 j
        boolean[] left = new boolean[2 * n - 1]; // 记录左斜线冲突  i+j
        boolean[] right = new boolean[2 * n - 1]; // 记录右斜线冲突 n-1-(i-j)
        char[][] table = new char[n][n]; // 棋盘  '.'  'Q'
        for (char[] chars : table) {
            Arrays.fill(chars, '.');
        }
        List<List<String>> result = new ArrayList<>();
        dfs(0, n, column, left, right, table, result);
        return result;
    }

    private void dfs(int i, int n, boolean[] column, boolean[] left, boolean[] right,
                     char[][] table, List<List<String>> result) {
        if (i == n) { // 找到解
            ArrayList<String> r = new ArrayList<>();
            for (char[] chars : table) {
                r.add(new String(chars));
            }
            result.add(r);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (column[j] || left[i + j] || right[n - 1 - (i - j)]) {
                continue;
            }
            table[i][j] = 'Q';
            column[j] = left[i + j] = right[n - 1 - (i - j)] = true;
            dfs(i + 1, n, column, left, right, table, result);
            table[i][j] = '.';
            column[j] = left[i + j] = right[n - 1 - (i - j)] = false;
        }
    }

    public static void main(String[] args) {
        Leetcode51 obj = new Leetcode51();
        List<List<String>> lists = obj.solveNQueens(1);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
