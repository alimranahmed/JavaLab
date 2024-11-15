package com.imranic.leetcode.stackandqeueue;

import java.util.Stack;

// 232. Implement Queue using Stacks
// https://leetcode.com/problems/implement-queue-using-stacks
public class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public MyQueue() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.pop();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int peek = second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peek;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
