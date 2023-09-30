package com.lee.datastructure.binarytree;

import com.lee.datastructure.binarytree.leetcode.Leetcode104_1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLeetcode104_1 {

    private final Leetcode104_1 e05 = new Leetcode104_1();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(3));
        assertEquals(2, e05.maxDepth(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(null, 3, new TreeNode(4)));
        assertEquals(3, e05.maxDepth(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, e05.maxDepth(root));
    }
}
