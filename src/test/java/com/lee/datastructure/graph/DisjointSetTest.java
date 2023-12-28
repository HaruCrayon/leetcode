package com.lee.datastructure.graph;

import org.junit.jupiter.api.Test;

/**
 * @author LiJing
 * @version 1.0
 */
class DisjointSetTest {

    @Test
    void test1() {
        DisjointSet set = new DisjointSet(7);
        System.out.println(set);
        // 1. 演示 Kruskal 算法执行流程，下面是边按权重排序顺序
        /*
            0 <--> 3
            5 <--> 6
            0 <--> 1
            2 <--> 3
            1 <--> 3
            0 <--> 2
            3 <--> 6
            2 <--> 5
            4 <--> 6
            3 <--> 4
            3 <--> 5
            1 <--> 4
        */
        int x = set.find(0);
        int y = set.find(3);
        System.out.println("老大分别是：" + x + " " + y);
        if (x != y) {
            set.union(x, y);
            System.out.println(set);
        }

        x = set.find(5);
        y = set.find(6);
        System.out.println("老大分别是：" + x + " " + y);
        if (x != y) {
            set.union(x, y);
            System.out.println(set);
        }

        x = set.find(0);
        y = set.find(1);
        System.out.println("老大分别是：" + x + " " + y);
        if (x != y) {
            set.union(x, y);
            System.out.println(set);
        }

        x = set.find(2);
        y = set.find(3);
        System.out.println("老大分别是：" + x + " " + y);
        if (x != y) {
            set.union(x, y);
            System.out.println(set);
        }

        x = set.find(1);
        y = set.find(3);
        System.out.println("老大分别是：" + x + " " + y);
        if (x != y) {
            set.union(x, y);
            System.out.println(set);
        }

        x = set.find(0);
        y = set.find(2);
        System.out.println("老大分别是：" + x + " " + y);
        if (x != y) {
            set.union(x, y);
            System.out.println(set);
        }

        x = set.find(3);
        y = set.find(6);
        System.out.println("老大分别是：" + x + " " + y);
        if (x != y) {
            set.union(x, y);
            System.out.println(set);
        }

        x = set.find(2);
        y = set.find(5);
        System.out.println("老大分别是：" + x + " " + y);
        if (x != y) {
            set.union(x, y);
            System.out.println(set);
        }

        x = set.find(4);
        y = set.find(6);
        System.out.println("老大分别是：" + x + " " + y);
        if (x != y) {
            set.union(x, y);
            System.out.println(set);
        }
    }

    @Test
    void test2() {
        DisjointSet set = new DisjointSet(7);
        System.out.println(set);
        // 2. 演示最糟情况(实际不可能出现,仅为演示)
        set.union(0, 1);
        set.union(1, 2);
        set.union(2, 3);
        set.union(3, 4);
        set.union(4, 5);
        set.union(5, 6);
        System.out.println(set);
        set.find(6);
        System.out.println(set);
    }

    @Test
    void test3() {
        DisjointSet set = new DisjointSet(5);

        set.union(1, 2);
        set.union(3, 4);
        set.union(1, 3);
        System.out.println(set);

        set.union(1, 0);
        System.out.println(set);
    }
}