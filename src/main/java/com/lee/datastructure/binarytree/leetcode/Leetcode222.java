package com.lee.datastructure.binarytree.leetcode;

import com.lee.datastructure.binarytree.TreeNode;

/**
 * @description: 完全二叉树的节点个数
 * @author: LiJing
 * @date: 2025/2/19
 */
public class Leetcode222 {
    /*
       对于最大层数为 h 的完全二叉树，节点个数一定在[2^h, 2^h+1 −1]的范围内

                          1                     h=0
                 /               \
                2                 3             h=1
            /      \           /      \
           4        5         6        7        h=2
         /  \     /  \      /  \     /  \
        8   9   10   11   12   13   14   15     h=3
     1000 1001 1010 1011 1100 1101 1110 1111    1 << h

        第k个节点的二进制表示：
            包含h+1位，其中最高位是1，其余各位从高到低表示从根节点到第k个节点的路径，
            0表示移动到左子节点，1表示移动到右子节点
     */

    // 方法1：二分查找 + 位运算
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 得到完全二叉树的最大层数
        TreeNode cur = root;
        int layer = 0;
        while (cur.left != null) {
            layer++;
            cur = cur.left;
        }
        // 使用二分查找确定节点个数
        int low = 1 << layer, high = (1 << (layer + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isExists(root, layer, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean isExists(TreeNode root, int layer, int k) {
        // 通过位运算得到第k个节点对应的路径
        int bits = 1 << (layer - 1);
        TreeNode cur = root;
        while (cur != null && bits > 0) {
            if ((bits & k) == 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
            bits >>= 1;
        }
        return cur != null;
    }
}
