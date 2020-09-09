package com.company.design_circular_deque;

// 构建一个双端循环队列
public class Three {
    //使用数组从左往右插入元素
    int[] arr;
    int size;
    int front;// 最前面元素的下标
    int end;// 最前面空位的下标

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public Three(int k) {
        size = k + 1;
        arr = new int[size];
        front = 0;
        end = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        front = (front - 1 + size) % size;
        arr[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        arr[end] = value;
        end = (end + 1) % size;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % size;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        end = (end - 1 + size) % size;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[((end - 1 + size) % size)];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == end;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (end + 1) % size == front;
    }
}
