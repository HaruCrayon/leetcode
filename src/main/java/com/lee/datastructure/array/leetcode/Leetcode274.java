package com.lee.datastructure.array.leetcode;

import java.util.Arrays;

/**
 * 274. H 指数
 *
 * @author LiJing
 * @date 2024-02-28
 */
public class Leetcode274 {
    /*
        n-i  5 4 3 2 1
        i    0 1 2 3 4
            [3,0,6,1,5]
            [0,1,3,5,6]
     */

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int i = n - 1;
        for (; i >= 0; i--) {
            if (citations[i] < n - i) {
                break;
            }
        }
        return n - i - 1;
    }

    public static int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex2(new int[]{3, 0, 6, 1, 5}));
    }
}
