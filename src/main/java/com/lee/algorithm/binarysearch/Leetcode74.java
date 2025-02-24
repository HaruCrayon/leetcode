package com.lee.algorithm.binarysearch;

/**
 * @description: 搜索二维矩阵
 * @author: LiJing
 * @date: 2025/2/24
 */
public class Leetcode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        for (int[] arr : matrix) {
            int i = 0, j = n - 1;
            while (i <= j) {
                int mid = (i + j) >>> 1;
                if (arr[mid] < target) {
                    i = mid + 1;
                } else if (arr[mid] > target) {
                    j = mid - 1;
                } else {
                    return true;
                }
            }
            if (i < n) {
                return false;
            }
        }
        return false;
    }
}
