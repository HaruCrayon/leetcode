package com.lee.datastructure.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LiJing
 * @version 1.0
 */
public class TestSinglyLinkedList {

    @Test
    @DisplayName("测试 addFirst")
    public void test1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop2(value -> {
            System.out.println(value);
        });
    }

    @Test
    @DisplayName("测试 迭代器遍历")
    public void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        // 增强for循环，底层是迭代器遍历
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试 addLast")
    public void test3() {
        SinglyLinkedList list = getLinkedList();
        assertIterableEquals(Arrays.asList(1, 2, 3, 4), list);
    }

    @Test
    @DisplayName("测试 get")
    public void test4() {
        SinglyLinkedList list = getLinkedList();
        assertEquals(3, list.get(2));
        assertThrows(IllegalArgumentException.class, () -> list.get(10));
    }

    @Test
    @DisplayName("测试 insert")
    public void test5() {
        SinglyLinkedList list = getLinkedList();
        list.insert(0, 5);
        assertIterableEquals(Arrays.asList(5, 1, 2, 3, 4), list);

        list = getLinkedList();
        list.insert(2, 5);
        assertIterableEquals(Arrays.asList(1, 2, 5, 3, 4), list);

        list = getLinkedList();
        list.insert(4, 5);
        assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), list);

        assertThrows(IllegalArgumentException.class, () -> getLinkedList().insert(5, 5));
    }

    @Test
    @DisplayName("测试 removeFirst")
    public void test6() {
        SinglyLinkedList list = getLinkedList();

        list.removeFirst();
        assertIterableEquals(Arrays.asList(2, 3, 4), list);
        list.removeFirst();
        assertIterableEquals(Arrays.asList(3, 4), list);
        list.removeFirst();
        assertIterableEquals(Arrays.asList(4), list);
        list.removeFirst();
        assertIterableEquals(Arrays.asList(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    @Test
    @DisplayName("测试 remove")
    public void test7() {
        SinglyLinkedList list1 = getLinkedList();
        list1.remove(2);
        assertIterableEquals(Arrays.asList(1, 2, 4), list1);

        SinglyLinkedList list2 = getLinkedList();
        list2.remove(0);
        assertIterableEquals(Arrays.asList(2, 3, 4), list2);

        SinglyLinkedList list3 = getLinkedList();
        assertThrows(IllegalArgumentException.class, () -> list3.remove(5));

        SinglyLinkedList list4 = getLinkedList();
        assertThrows(IllegalArgumentException.class, () -> list4.remove(4));
    }

    @Test
    @DisplayName("测试 递归遍历")
    public void test8() {
        SinglyLinkedList list = getLinkedList();
        list.loop3(value -> {
            System.out.println("before:" + value);
        }, value -> {
            System.out.println("after:" + value);
        });
    }

    private SinglyLinkedList getLinkedList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }
}
