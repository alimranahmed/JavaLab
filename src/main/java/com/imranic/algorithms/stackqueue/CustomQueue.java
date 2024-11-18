package com.imranic.algorithms.stackqueue;

public class CustomQueue {
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    private int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    private boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) throws Exception {
        if (isFull()) {
            throw new Exception("The queue is full");
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[0];
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < end; i++) {
            output += data[i] + " <- ";
        }
        output += "END";
        return output;
    }
}
