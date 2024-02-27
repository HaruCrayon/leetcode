package com.lee.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 *
 * @author LiJing
 * @date 2024-02-23
 */
public class Leetcode728 {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (i >= 1 && i <= 9) {
                res.add(i);
                continue;
            }
            if (isSelfDivide(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean isSelfDivide(int num) {
        int n = num;
        while (n != 0) {
            int mod = n % 10;
            if (mod == 0 || num % mod != 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
        System.out.println(selfDividingNumbers(47, 85));
    }
}
