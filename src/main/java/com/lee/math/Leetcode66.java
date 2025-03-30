package com.lee.math;

/**
 * @description: 加一
 * @author: LiJing
 * @date: 2025/2/28
 */
public class Leetcode66 {

    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int num = digits[digits.length - 1] + 1;
        if (num == 10) {
            digits[digits.length - 1] = 0;
            carry = 1;
        } else {
            digits[digits.length - 1] += 1;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] + carry == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] += carry;
                carry = 0;
            }
        }
        int[] newArr = new int[digits.length + 1];
        if (carry == 1) {
            System.arraycopy(digits, 0, newArr, 1, digits.length);
            newArr[0] = 1;
            return newArr;
        } else {
            return digits;
        }
    }

}
