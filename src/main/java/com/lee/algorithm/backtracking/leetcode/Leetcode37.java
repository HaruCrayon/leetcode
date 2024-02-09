package com.lee.algorithm.backtracking.leetcode;

import java.util.Arrays;

/**
 * 37. 解数独
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode37 {
    /*
        1. 不断遍历每个未填的空格
           逐一尝试 1~9，若行、列、'3x3宫'都没有冲突，则填入
        2. 一旦 1~9 都尝试失败，回溯到上一次状态，换数字填入
        3. 关键是要记录冲突状态
     */

    public void solveSudoku(char[][] board) {
        // 记录行冲突
        boolean[][] row = new boolean[9][9];
        // 记录列冲突
        boolean[][] column = new boolean[9][9];
        // 记录'3x3宫'冲突，空格(i,j) 对应第 (i/3*3 + j/3) 个'3x3宫'
        boolean[][] grid = new boolean[9][9];
        // 初始化冲突状态
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    row[i][ch - '1'] = true;
                    column[j][ch - '1'] = true;
                    grid[i / 3 * 3 + j / 3][ch - '1'] = true;
                }
            }
        }

        dfs(0, 0, board, row, column, grid);
    }

    private boolean dfs(int i, int j, char[][] board, boolean[][] row, boolean[][] column, boolean[][] grid) {
        while (board[i][j] != '.') { // 查找下一个空白格
            if (++j >= 9) {
                j = 0;
                i++;
            }
            if (i >= 9) { // 找到解
                return true;
            }
        }
        for (int x = 1; x <= 9; x++) {
            // 检查冲突
            if (row[i][x - 1] || column[j][x - 1] || grid[i / 3 * 3 + j / 3][x - 1]) {
                continue;
            }
            // 填入数字
            board[i][j] = (char) (x + '0');
            // 记录填入数字后的冲突
            row[i][x - 1] = column[j][x - 1] = grid[i / 3 * 3 + j / 3][x - 1] = true;
            if (dfs(i, j, board, row, column, grid)) {
                return true;
            }
            board[i][j] = '.';
            row[i][x - 1] = column[j][x - 1] = grid[i / 3 * 3 + j / 3][x - 1] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode37 obj = new Leetcode37();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        obj.solveSudoku(board);
        print(board);
    }

    static char[][] solved = {
            {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
    };

    private static void print(char[][] board) {
        for (char[] chars : board) {
            System.out.println(new String(chars));
        }
        System.out.println(Arrays.deepEquals(board, solved));
    }
}
