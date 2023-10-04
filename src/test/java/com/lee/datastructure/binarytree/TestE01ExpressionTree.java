package com.lee.datastructure.binarytree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestE01ExpressionTree {

    E01ExpressionTree e01 = new E01ExpressionTree();

    @Test
    void test1() {
        String[] tokens = {"2", "1", "-", "3", "*"};
        E01ExpressionTree.TreeNode root = e01.constructExpressionTree(tokens);
        assertArrayEquals(tokens, post(root).toArray(new String[0]));
    }

    @Test
    void test2() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        E01ExpressionTree.TreeNode root = e01.constructExpressionTree(tokens);
        ArrayList<String> result = new ArrayList<>();

        assertArrayEquals(tokens, post(root).toArray(new String[0]));
    }

    private ArrayList<String> post(E01ExpressionTree.TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        doPost(root, result);
        return result;
    }

    private void doPost(E01ExpressionTree.TreeNode node, ArrayList<String> result) {
        if (node == null) {
            return;
        }
        doPost(node.left, result);
        doPost(node.right, result);
        result.add(node.val);
    }
}