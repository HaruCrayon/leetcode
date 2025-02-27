package com.lee.datastructure.array.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 螺旋矩阵
 * @author: LiJing
 * @date: 2025/2/26
 */
public class Leetcode54 {
    /*
            1  2  3  4  5  1
            6  7  8  9  0  2
            1  2  3  4  5  3
            6  7  8  9  0  4
            1  2  3  4  5  5

     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        // 上下左右边界
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        // 有圈可转，转一圈
        while (top < bottom && left < right) {
            // 每条边都按左闭右开的规则去移动
            for (int i = left; i < right; i++) { // 左 → 右
                ans.add(matrix[top][i]);
            }
            for (int i = top; i < bottom; i++) { // 上 → 下
                ans.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) { // 右 → 左
                ans.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > top; i--) { // 下 → 上
                ans.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        // 无圈可转，处理最后一横条或一竖条
        if (top == bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
        } else if (left == right) {
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][left]);
            }
        }
        return ans;
    }
}
