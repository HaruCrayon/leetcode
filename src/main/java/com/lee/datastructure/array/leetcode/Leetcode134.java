package com.lee.datastructure.array.leetcode;

/**
 * 134. 加油站
 *
 * @author LiJing
 * @date 2024-02-29
 */
public class Leetcode134 {
    /*
                0  1  2  3  4
        gas =  [1, 2, 3, 4, 5]
        cost = [3, 4, 5, 1, 2]
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0; // 出发点
        while (start < n) {
            int i = start;
            int gases = 0;
            int costs = 0;
            int cnt = 0;
            while (cnt < n) {
                gases += gas[i % n];
                costs += cost[i % n];
                if (gases < costs) {
                    break;
                }
                i++;
                cnt++;
            }
            if (cnt == n) {
                return start;
            } else {
                // 重置出发点
                // 如果x无法到达y的下一个加油站，那么[x,y]之间所有的都无法到达，那么就要从y+1出发
                start = i + 1;
            }
        }
        return -1;
    }
}
