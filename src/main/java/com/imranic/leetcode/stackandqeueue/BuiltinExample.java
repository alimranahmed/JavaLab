package com.imranic.leetcode.stackandqeueue;

import java.util.*;

public class BuiltinExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // Queue is an abstract class, it doesn't have any concrete class
        // But LinkedList implements queue, so we can use LinkedList as queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        // This is a kind of queue where we can remove and end from both side
        Deque<Integer> doubleEndedQueue = new ArrayDeque<>();
        doubleEndedQueue.addFirst(2);
        doubleEndedQueue.addLast(3);
        doubleEndedQueue.removeFirst();
        System.out.println(doubleEndedQueue);
    }
}
