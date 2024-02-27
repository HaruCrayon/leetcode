package com.lee.datastructure.array.leetcode;

/**
 * 27. 移除元素
 *
 * @author LiJing
 * @date 2024-02-27
 */
public class Leetcode27 {

    /*
         i                    j
        [0, 1, 2, 2, 3, 0, 4, 2]   2

     */

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int len = nums.length;
        while (i <= j) {
            while (i <= j && nums[j] == val) {
                len--;
                j--;
            }
            if (i <= j && nums[i] == val) {
                swap(nums, i, j);
            }
            i++;
        }
        /*while (i <= j) {
            while (i <= j && nums[j] == val) {
                len--;
                j--;
            }
            while (i <= j && nums[i] != val) {
                i++;
            }
            if (i <= j) {
                swap(nums, i, j);
            }
        }*/
        return len;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
