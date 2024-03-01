package com.lee.datastructure.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 *
 * @author LiJing
 * @date 2024-03-02
 */
public class Leetcode6 {
    /*
        输入：s = "PAYPALISHIRING", numRows = 4
        输出："PINALSIGYAHRPI"

        P     I    N
        A   L S  I G
        Y A   H R
        P     I

     */

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int idx = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            rows.get(idx).append(s.charAt(i));
            if (idx == 0 || idx == numRows - 1) {
                flag = -flag;
            }
            idx += flag;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
