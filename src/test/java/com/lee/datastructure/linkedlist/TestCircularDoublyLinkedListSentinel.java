package com.lee.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestCircularDoublyLinkedListSentinel {

    @Test
    public void addFirst() {
        CircularDoublyLinkedListSentinel list = new CircularDoublyLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        assertIterableEquals(Arrays.asList(5, 4, 3, 2, 1), list);
    }

    @Test
    public void addLast() {
        CircularDoublyLinkedListSentinel list = new CircularDoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    public void removeFirst() {
        CircularDoublyLinkedListSentinel list = getList();
        list.removeFirst();
        assertIterableEquals(Arrays.asList(2, 3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(Arrays.asList(3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(Arrays.asList(4, 5), list);
        list.removeFirst();
        assertIterableEquals(Arrays.asList(5), list);
        list.removeFirst();
        assertIterableEquals(Arrays.asList(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    @Test
    public void removeLast() {
        CircularDoublyLinkedListSentinel list = getList();
        list.removeLast();
        assertIterableEquals(Arrays.asList(1, 2, 3, 4), list);
        list.removeLast();
        assertIterableEquals(Arrays.asList(1, 2, 3), list);
        list.removeLast();
        assertIterableEquals(Arrays.asList(1, 2), list);
        list.removeLast();
        assertIterableEquals(Arrays.asList(1), list);
        list.removeLast();
        assertIterableEquals(Arrays.asList(), list);
        assertThrows(IllegalArgumentException.class, list::removeLast);
    }

    @Test
    public void removeByValue() {
        CircularDoublyLinkedListSentinel list = getList();
        list.removeByValue(1);
        assertIterableEquals(Arrays.asList(2, 3, 4, 5), list);
        list.removeByValue(2);
        assertIterableEquals(Arrays.asList(3, 4, 5), list);
        list.removeByValue(3);
        assertIterableEquals(Arrays.asList(4, 5), list);
        list.removeByValue(4);
        assertIterableEquals(Arrays.asList(5), list);
        /*list.removeByValue(5);
        assertIterableEquals(Arrays.asList(), list);*/
        list.removeByValue(10);
        assertIterableEquals(Arrays.asList(5), list);
    }

    private CircularDoublyLinkedListSentinel getList() {
        CircularDoublyLinkedListSentinel list = new CircularDoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        return list;
    }
}