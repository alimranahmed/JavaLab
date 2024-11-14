package com.imranic.leetcode.stackandqeueue;

public class CustomQueueExample {
    public static void main(String[] args) throws Exception {
//        CustomQueue queue = new CustomQueue();
//        queue.insert(1);
//        queue.insert(2);
//        queue.insert(3);
//        queue.insert(4);
//        queue.insert(5);
//
//        System.out.println(queue);
//
//        System.out.println(queue.remove());
//
//        System.out.println(queue);

        CircularQueue queue = new CircularQueue();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue.insert(55));
        System.out.println(queue.remove());

        System.out.println(queue);
    }
}
