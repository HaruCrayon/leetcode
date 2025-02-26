package com.lee.datastructure.array.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 汇总区间
 * @author: LiJing
 * @date: 2025/2/25
 */
public class Leetcode228 {
    /*
        输入：nums = [0,1,2,4,5,7]
        输出：["0->2","4->5","7"]

        输入：nums = [0,2,3,4,6,8,9]
        输出：["0","2->4","6","8->9"]
     */

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[left] + right - left == nums[right]) {
                right++;
            }
            if (right - left == 1) {
                res.add(nums[left] + "");
            } else {
                res.add(nums[left] + "->" + nums[right - 1]);
            }
            left = right;
        }
        return res;
    }
}
