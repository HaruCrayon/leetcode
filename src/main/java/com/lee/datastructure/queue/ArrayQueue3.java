package com.lee.datastructure.queue;

import java.util.Iterator;

/**
 * 环形数组实现队列
 * 仅用 head, tail 判断空满, head, tail 需要换算成索引值
 *
 * @author LiJing
 * @version 1.0
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {

    /**
     * <h3>head 和 tail 不断递增，用到索引时，再用它们进行计算，两个问题</h3>
     * <p>1. 如何保证 head 和 tail 自增超过正整数最大值的正确性</p>
     * <p>2. 如何让取模运算性能更高</p>
     * <p>答案：让 capacity 为 2 的幂</p>
     */

    /*
        求模运算：
        - 如果除数是 2 的 n 次方
        - 那么被除数的后 n 位即为余数 (模)
        - 求被除数的后 n 位方法： 与 2^n-1 按位与
     */

    private final E[] array;
    int head = 0;
    int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue3(int c) {
        // 让 capacity 为 2 的幂

        // 策略1. 抛异常
        /*if ((c & c - 1) != 0) {
            throw new IllegalArgumentException("capacity 必须是2的幂");
        }*/

        // 策略2. 改成离 capacity 最近，比 capacity 大的 2^n   例如：13 -> 16   22 -> 32
        c -= 1;
        c |= c >> 1;
        c |= c >> 2;
        c |= c >> 4;
        c |= c >> 8;
        c |= c >> 16;
        c += 1;
        array = (E[]) new Object[c];
    }

    /**
     * 向队列尾插入值. 有的习惯命名为 enqueue
     *
     * @param value 待插入值
     * @return 插入成功返回 true, 插入失败返回 false
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail & (array.length - 1)] = value;
        tail++;
        return true;
    }

    /**
     * 从队列头获取值, 并移除. 有的习惯命名为 dequeue
     *
     * @return 如果队列非空返回队头值, 否则返回 null
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int idx = head & (array.length - 1);
        E value = array[idx];
        array[idx] = null; // help GC
        head++;
        return value;
    }

    /**
     * 从队列头获取值, 不移除
     *
     * @return 如果队列非空返回对头值, 否则返回 null
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head & (array.length - 1)];
    }

    /**
     * 检查队列是否为空
     *
     * @return 空返回 true, 否则返回 false
     */
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 检查队列是否已满
     *
     * @return 满返回 true, 否则返回 false
     */
    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p & (array.length - 1)];
                p++;
                return value;
            }
        };
    }
}
