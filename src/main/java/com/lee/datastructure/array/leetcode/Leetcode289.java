package com.lee.datastructure.array.leetcode;

/**
 * @description: 生命游戏
 * @author: LiJing
 * @date: 2025/2/27
 */
public class Leetcode289 {
    /*
            当前状态   周围活细胞数   下一个状态     存储状态(二进制位：最后一位存储原来的状态，倒数第二位存储更新后的状态)
            1           <2             0            01
            1           =2 =3          1            11
            1           >3             0            01
            0           =3             1            10
     */

    public static void gameOfLife(int[][] board) {
        int rowNums = board.length;
        int colNums = board[0].length;
        // 更新存储状态
        for (int i = 0; i < rowNums; i++) {
            for (int j = 0; j < colNums; j++) {
                int liveNums = countLiveNums(board, i, j);
                if ((board[i][j] & 1) == 1) {
                    if (liveNums == 2 || liveNums == 3) {
                        board[i][j] = (1 << 1) + 1;
                    }
                } else {
                    if (liveNums == 3) {
                        board[i][j] = 1 << 1;
                    }
                }
            }
        }
        // 更新 board
        for (int i = 0; i < rowNums; i++) {
            for (int j = 0; j < colNums; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private static int countLiveNums(int[][] board, int i, int j) {
        int cnt = 0;
        for (int m = -1; m <= 1; m++) {
            for (int n = -1; n <= 1; n++) {
                if (m == 0 && n == 0) {
                    continue;
                }
                int x = i + m;
                int y = j + n;
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                    continue;
                }
                if ((board[x][y] & 1) == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
