package com.lee.algorithm.backtracking.leetcode;

/**
 * @description: 单词搜索
 * @date: 2025/3/23
 */
public class Leetcode79 {
    private final int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();

        // 优化：若word中某个字符出现次数比board还多，那必然不可能组成单词，直接返回
        int[] bdCnt = new int[128], wdCnt = new int[128];
        for (char[] row : board) {
            for (char c : row) {
                bdCnt[c]++;
            }
        }
        for (char c : chars) {
            if (++wdCnt[c] > bdCnt[c]) {
                return false;
            }
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, visited, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, boolean[][] visited, char[] chars, int place) {
        if (board[i][j] != chars[place]) {
            return false;
        } else if (place == chars.length - 1) {
            return true;
        }

        visited[i][j] = true;
        for (int[] direct : directs) {
            int row = i + direct[0], col = j + direct[1];
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
                if (!visited[row][col]) {
                    if (dfs(row, col, board, visited, chars, place + 1)) {
                        return true;
                    }
                }
            }
        }

        visited[i][j] = false;
        return false;
    }
}
