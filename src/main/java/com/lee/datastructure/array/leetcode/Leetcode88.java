package com.lee.datastructure.array.leetcode;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @author LiJing
 * @date 2024-02-27
 */
public class Leetcode88 {
    /*
                     i     k                       j
        nums1 = [1,2,3,0,0,0]         nums2 = [2,5,6]
                [1,4,0,0,0,0]                 [2,3,5,6]
                [4,0,0,0,0,0]                 [1,2,3,5,6]
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        int i = m - 1; // nums1 索引
        int j = n - 1; // nums2 索引
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums2[j] >= nums1[i]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }

        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
//        int[] nums1 = new int[]{4, 0, 0, 0, 0, 0};
//        int[] nums2 = new int[]{1, 2, 3, 5, 6};
//        merge(nums1, 1, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }
}
