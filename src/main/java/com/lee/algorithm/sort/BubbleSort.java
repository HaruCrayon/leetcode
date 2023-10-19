package com.lee.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author LiJing
 * @version 1.0
 */
public class BubbleSort {

    public static void sort(int[] a) {
        int j = a.length - 1;
        do {
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    // 交换
                    swap(a, i, i + 1);
                    x = i;
                }
            }
            j = x; // 调整未排序的右边界，减少不必要比较
        } while (j != 0);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
