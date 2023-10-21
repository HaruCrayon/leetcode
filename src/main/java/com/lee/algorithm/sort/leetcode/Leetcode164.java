package com.lee.algorithm.sort.leetcode;

/**
 * 164. 最大间距
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode164 {
    /*
        给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值。如果数组元素个数小于 2，则返回 0 。
        必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
        提示:
        1 <= nums.length <= 10^5
        0 <= nums[i] <= 10^9
     */

    public int maximumGap(int[] nums) {
        // 1. 处理特殊情况
        if (nums.length < 2) {
            return 0;
        }

        // 2. 桶排序
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        // 2.1 准备桶
        /*
            计算桶个数                   期望桶个数
            (max - min) / range + 1 = nums.length + 1
            (max - min) / range = nums.length
         */

        // 让桶的个数比元素多一个
        int range = Math.max((max - min) / nums.length, 1);
        int bucketNum = (max - min) / range + 1;
        Pair[] buckets = new Pair[bucketNum];

        // 2.2 放入数据
        for (int v : nums) {
            int idx = (v - min) / range;
            if (buckets[idx] == null) {
                buckets[idx] = new Pair();
            }
            // 桶内只需保存该桶的最大值和最小值
            buckets[idx].add(v);
        }

        // 3. 寻找最大差值
        int r = 0;
        int lastMax = buckets[0].max;
        for (int i = 1; i < buckets.length; i++) {
            Pair bucket = buckets[i];
            if (bucket != null) {
                r = Math.max(bucket.min - lastMax, r);
                lastMax = bucket.max;
            }
        }

        return r;
    }

    // 数据范围 0 <= nums[i] <= 1000_000_000
    static class Pair {
        int max = 0;
        int min = 1000_000_000;

        // 更新桶内最大值和最小值
        void add(int v) {
            max = Math.max(v, max);
            min = Math.min(v, min);
        }

        @Override
        public String toString() {
            return "[" + max +
                    "," + min +
                    ']';
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 220};
        int r = new Leetcode164().maximumGap(nums);
        System.out.println(r);
    }

    /*
        有没有可能，桶内元素的间距比桶间元素间距还大？
        有空桶 ==> 桶间元素间距更大
        让桶的个数比元素多一个 ==> 有空桶
     */
}
