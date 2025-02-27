package com.lee.datastructure.array.leetcode;

/**
 * @description: 旋转图像
 * @author: LiJing
 * @date: 2025/2/27
 */
public class Leetcode48 {
    /*
        5  1  9  11             15 13  2  5
        2  4  8  10     ==>     14  3  4  1
        13 3  6  7              12  6  8  9
        15 14 12 16             16  7 10 11

        自外向内一共有不超过 n/2 层矩形框（单个中心元素不算一层）。
        对于第 times 层矩形框，其框边长 len=nums−(times∗2)，
        将其顺时针分为 4 份 len−1 的边，对四条边进行元素的循环交换
     */

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length == 1) {
            return;
        }
        // 上下左右边界
        int top = 0, bottom = length - 1, left = 0, right = length - 1;
        int times = 0;
        while (times < length / 2) {
            int curLen = length - times * 2;
            for (int i = 0; i < curLen - 1; i++) {
                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            top++;
            bottom--;
            left++;
            right--;
            times++;
        }
    }
}
