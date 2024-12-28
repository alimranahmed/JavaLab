package com.imranic.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    public void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public List<Integer> inOrder() {
        List<Integer> list = new ArrayList<>();
        this.inOrder(this.root, list);
        return list;
    }

    public void inOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        this.inOrder(node.left, list);
        list.add(node.value);
        this.inOrder(node.right, list);
    }

    public List<Integer> preOrder() {
        List<Integer> list = new ArrayList<>();
        this.preOrder(this.root, list);
        return list;
    }

    public void preOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.value);
        this.preOrder(node.left, list);
        this.preOrder(node.right, list);

    }

    public void display() {
        BinaryTreePrinter.printTree(this.root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public int height() {
        return this.height(this.root);
    }

    public boolean balanced() {
        return balanced(root);
    }

    public boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1
                && balanced(node.left)
                && balanced(node.right);
    }
}
