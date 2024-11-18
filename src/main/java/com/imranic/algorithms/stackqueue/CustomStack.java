package com.imranic.algorithms.stackqueue;

public class CustomStack {
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    private int pointer = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) throws Exception {
        if (isFull()) {
            throw new Exception("Stack overflow");
        }
        pointer++;
        data[pointer] = item;
        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an empty stack!");
        }
        return data[pointer--];
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("No peek of an empty stack!");
        }
        return data[pointer];
    }

    public boolean isFull() {
        return pointer == data.length - 1;
    }

    private boolean isEmpty() {
        return pointer == -1;
    }
}
