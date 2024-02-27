package com.lee.math;

import java.util.Arrays;

/**
 * 2160. 拆分数位后四位数字的最小和
 *
 * @author LiJing
 * @date 2024-02-23
 */
public class Leetcode2160 {

    public static int minimumSum(int num) {
        int[] arr = new int[4];
        int i = 0;
        while (num != 0) {
            int mod = num % 10;
            arr[i++] = mod;
            num = num / 10;
        }
        Arrays.sort(arr);
        return (arr[0] + arr[1]) * 10 + arr[2] + arr[3];
    }

    public static void main(String[] args) {
        System.out.println(minimumSum(2932)); // 52
        System.out.println(minimumSum(4009)); // 13
    }
}
