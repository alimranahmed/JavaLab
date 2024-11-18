package com.imranic.algorithms.stackqueue;

public class CustomStackExample {
    public static void main(String[] args) throws Exception {
//        CustomStack stack = new CustomStack();
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        DynamicStack dynamicStack = new DynamicStack();
        dynamicStack.push(1);
        dynamicStack.push(2);
        dynamicStack.push(3);
        dynamicStack.push(4);
        dynamicStack.push(5);
        dynamicStack.push(6);
        dynamicStack.push(7);
        dynamicStack.push(8);
        dynamicStack.push(9);
        dynamicStack.push(10);
        dynamicStack.push(11);
        System.out.println(dynamicStack.peek());
        System.out.println(dynamicStack.pop());
        System.out.println(dynamicStack.pop());
        System.out.println(dynamicStack.pop());

    }
}
