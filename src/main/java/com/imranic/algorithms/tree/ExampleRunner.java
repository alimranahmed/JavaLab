package com.imranic.algorithms.tree;

public class ExampleRunner {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < 1000; i++) {
            avlTree.insert(i);
        }

        avlTree.display();
        System.out.println(avlTree.height());
    }
}
