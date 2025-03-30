package com.lee.algorithm.divideandconquer.leetcode;

/**
 * @description: 建立四叉树
 * @date: 2025/3/29
 */
public class Leetcode427 {

    public Node construct(int[][] grid) {
        return recursion(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    private Node recursion(int[][] grid, int r1, int r2, int c1, int c2) {
        if (r1 == r2 && c1 == c2) {
            return new Node(grid[r1][c1] == 1, true);
        }
        int rm = (r1 + r2) >> 1, cm = (c1 + c2) >> 1;
        Node topLeft = recursion(grid, r1, rm, c1, cm);
        Node topRight = recursion(grid, r1, rm, cm + 1, c2);
        Node bottomLeft = recursion(grid, rm + 1, r2, c1, cm);
        Node bottomRight = recursion(grid, rm + 1, r2, cm + 1, c2);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && bottomLeft.val == bottomRight.val && topLeft.val == bottomLeft.val) {
            return new Node(topLeft.val, true);
        }
        return new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
