package com.lee.datastructure.array;

import java.util.Arrays;

/**
 * 合并两个有序数组 (LeetCode 88 题改)
 * 将一个数组两个区间内的有序元素合并
 *
 * @author LiJing
 * @version 1.0
 */
public class E01Merge2SortedArray {
    /*
        [1, 5, 6, 2, 4, 10, 11]
        可以视作两个有序区间  [1, 5, 6] 和 [2, 4, 10, 11]
        合并后，结果仍存储于原有空间  [1, 2, 4, 5, 6, 10, 11]
     */

    /**
     * 方法1 - 递归
     * <p>每次递归把更小的元素复制到结果数组</p>
     *
     * @param a1   原始数组
     * @param i    第一个有序区间的起点
     * @param iEnd 第一个有序区间的终点
     * @param j    第二个有序区间的起点
     * @param jEnd 第二个有序区间的终点
     * @param a2   结果数组
     * @param k    结果数组的索引位置
     */
    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd,
                             int[] a2, int k) {
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
            return;
        }

        if (a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        } else {
            a2[k] = a1[j];
            merge(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
    }

    // 方法2
    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        int k = 0;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            } else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }

        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 5, 6, 2, 4, 10, 11};
        int[] a2 = new int[a1.length];
//        merge(a1, 0, 2, 3, 6, a2, 0);
        merge(a1, 0, 2, 3, 6, a2);
        System.out.println(Arrays.toString(a2));
        System.arraycopy(a2, 0, a1, 0, a2.length);
        System.out.println(Arrays.toString(a1));
    }
}
