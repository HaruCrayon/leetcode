package com.lee.datastructure.array.leetcode;

/**
 * @description: 有效的数独
 * @author: LiJing
 * @date: 2025/2/26
 */
public class Leetcode36 {
    /*
        1.建立哈希表来存储任一个数在相应维度上是否出现过。维度有3个：所在的行，所在的列，所在的box
        2.遍历到每个数的时候，board[i][j]，判断其是否满足三个条件：
            在第 i 个行中是否出现过
            在第 j 个列中是否出现过
            在第 j/3 + (i/3)*3 个box中是否出现过
     */

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curNum = board[i][j] - '1';
                int x = j / 3 + (i / 3) * 3;
                if (row[i][curNum] == 1 || col[j][curNum] == 1 || box[x][curNum] == 1) {
                    return false;
                }
                row[i][curNum] = 1;
                col[j][curNum] = 1;
                box[x][curNum] = 1;
            }
        }
        return true;
    }
}
