package com.imranic.algorithms.tree;

public class ExampleRunner {
    public static void main(String[] args) {
//        ExampleRunner.runAvlTree();
        ExampleRunner.runBinarySearchTree();
    }

    private static void runBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.populate(new int[]{50, 10, 60, 5, 20, 55, 70});
        bst.display();
        System.out.println("Height: " + bst.height());
        System.out.println("In-Order: " + bst.inOrder());
        System.out.println("Pre-Order: " + bst.preOrder());
    }

    private static void runAvlTree() {
        AVLTree avlTree = new AVLTree();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        for (int num : nums) {
            avlTree.insert(num);
        }

        avlTree.display();
        System.out.println("Height: " + avlTree.height());
    }
}
