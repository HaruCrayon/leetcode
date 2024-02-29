package com.lee.datastructure.array.leetcode;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author LiJing
 * @date 2024-02-29
 */
public class Leetcode238 {
    /*
        原数组：       [1       2       3       4]
        左部分的乘积：   1       1      1*2    1*2*3
        右部分的乘积： 2*3*4    3*4      4      1
        结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
     */

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int tmp = 1;
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }
        return ans;
    }
}
