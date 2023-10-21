package com.lee.algorithm.sort.leetcode;

import java.util.Arrays;

/**
 * 1122. 数组的相对排序
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode1122 {
    /*
        给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
        对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
        未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

        前提
        1. 元素值范围 [0, 1000]
        2. 两个数组长度 <= 1000
     */

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1) {
            count[i]++;
        }
        int[] result = new int[arr1.length];
        int k = 0;
        for (int v : arr2) {
            while (count[v] > 0) {
                result[k++] = v;
                count[v]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[k++] = i;
                count[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1, 2, 2, 1, 2, 5, 4};
        int[] arr2 = {2, 3, 1};

        Leetcode1122 leetcode = new Leetcode1122();
        int[] result = leetcode.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
