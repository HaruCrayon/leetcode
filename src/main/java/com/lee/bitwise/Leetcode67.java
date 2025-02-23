package com.lee.bitwise;

/**
 * @description: 二进制求和
 * @author: LiJing
 * @date: 2025/2/22
 */
public class Leetcode67 {
    /*
        1011010
           1101
     */

    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int aNum = 0, bNum = 0;
            if (a.length() - i - 1 >= 0) {
                aNum = a.charAt(a.length() - i - 1) == '1' ? 1 : 0;
            }
            if (b.length() - i - 1 >= 0) {
                bNum = b.charAt(b.length() - i - 1) == '1' ? 1 : 0;
            }
            int sum = aNum + bNum + carry; // 0 1 2 3
            sb.append(sum % 2);
            carry = sum > 1 ? 1 : 0;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
