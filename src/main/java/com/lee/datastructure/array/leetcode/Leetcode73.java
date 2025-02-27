package com.lee.datastructure.array.leetcode;

/**
 * @description: 矩阵置零
 * @author: LiJing
 * @date: 2025/2/27
 */
public class Leetcode73 {

    public void setZeroes(int[][] matrix) {
        int rowNums = matrix.length, colNums = matrix[0].length;
        // 第一行本身是否有零以及第一列本身是否有零，用额外的标志位记录
        boolean flagRow0 = false, flagCol0 = false;
        for (int i = 0; i < rowNums; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
                break;
            }
        }
        for (int i = 0; i < colNums; i++) {
            if (matrix[0][i] == 0) {
                flagRow0 = true;
                break;
            }
        }
        // 把第一行第一列作为标志位，记录该列该行是否有零
        for (int i = 1; i < rowNums; i++) {
            for (int j = 1; j < colNums; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 矩阵置零
        for (int i = 1; i < rowNums; i++) {
            for (int j = 1; j < colNums; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagRow0) {
            for (int i = 0; i < colNums; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flagCol0) {
            for (int i = 0; i < rowNums; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
