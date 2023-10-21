package com.lee.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * <h3>桶排序</h3>
 */
public class BucketSort {

    public static void sort(int[] a, int range) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        // 1. 准备桶
        ArrayList<Integer>[] buckets = new ArrayList[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 2. 放入数据
        for (int num : a) {
            buckets[(num - min) / range].add(num);
        }
        int k = 0;
        for (ArrayList<Integer> bucket : buckets) {
            // 3. 排序桶内元素
            Collections.sort(bucket);
//            System.out.println(bucket);
            // 4. 把每个桶排序好的内容，依次放入原始数组
            for (Integer v : bucket) {
                a[k++] = v;
            }
        }
    }

    /*
        0   0,1,2
        1   3,4,5
        2   6,7,8
        3   9
     */
    public static void main(String[] args) {
        int[] ages = {9, 0, 5, 1, 3, 2, 4, 6, 8, 7};
        System.out.println(Arrays.toString(ages));
        sort(ages, 3);
        System.out.println(Arrays.toString(ages));
    }
}
