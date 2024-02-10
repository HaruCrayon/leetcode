package com.lee.algorithm.twopointers;

/**
 * 11. 盛最多水的容器
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode11 {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int area;
        // 向中间不断缩减距离，每次改变较短的挡板
        while (i < j) {
            if (height[i] < height[j]) {
                area = (j - i) * height[i];
                i++;
            } else {
                area = (j - i) * height[j];
                j--;
            }
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode11 obj = new Leetcode11();
        System.out.println(obj.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
