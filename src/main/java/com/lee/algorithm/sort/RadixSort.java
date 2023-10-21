package com.lee.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h3>基数排序 最低有效数字 LSD(Least significant digit)</h3>
 */
public class RadixSort {

    public static void sort(String[] a, int length) {
        // 1. 准备桶
        ArrayList<String>[] buckets = new ArrayList[128]; // 0~127
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 2. 进行多轮按位桶排序
        for (int i = length - 1; i >= 0; i--) {
            // 将字符串放入合适的桶
            for (String s : a) {
                buckets[s.charAt(i)].add(s);
            }
            // 重新取出排好序的字符串，放回原始数组
            int k = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String s : bucket) {
                    a[k++] = s;
                }
                bucket.clear();
            }
//            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        String[] phoneNumbers = new String[10];
        phoneNumbers[0] = "13812345678";
        phoneNumbers[1] = "13912345678";
        phoneNumbers[2] = "13612345678";
        phoneNumbers[3] = "13712345678";
        phoneNumbers[4] = "13512345678";
        phoneNumbers[5] = "13412345678";
        phoneNumbers[6] = "15012345678";
        phoneNumbers[7] = "15112345678";
        phoneNumbers[8] = "15212345678";
        phoneNumbers[9] = "15712345678";

        sort(phoneNumbers, 11);
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }
}
