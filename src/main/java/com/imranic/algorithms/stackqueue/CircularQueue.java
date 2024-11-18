package com.imranic.algorithms.stackqueue;

public class CircularQueue{
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    private int end = 0;
    private int front = 0;
    private int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) throws Exception {
        if (isFull()) {
            throw new Exception("The queue is full");
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[front];
    }

    public String toString() {
        if (isEmpty()) {
            return "[Empty]";
        }
        String output = "";
        int i = front;
        do {
            output += data[i] + " <- ";
            i++;
            i %= data.length;
        } while (i != end);
        output += "END";
        return output;
    }
}
