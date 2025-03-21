package com.imranic.algorithms.tree;

// This is a self-balancing binary search tree
// After insertion in insert() method, we are balancing the tree using rotation
public class AVLTree {
    private TreeNode root;

    public void insert(int value) {
        root = insert(value, root);
    }

    private TreeNode insert(int value, TreeNode node) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.val) {
            node.left = insert(value, node.left);
        }

        if (value > node.val) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);
    }

    private TreeNode rotate(TreeNode node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.right) - height(node.left) > 1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // right left case
                node.left = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public TreeNode leftRotate(TreeNode parent) {
        TreeNode child = parent.right;
        TreeNode t = child.left;

        child.left = parent;
        parent.right = t;
        parent.height = Math.max(height(parent.right), height(parent.left)) + 1;
        child.height = Math.max(height(child.right), height(child.left)) + 1;

        return child;
    }

    public TreeNode rightRotate(TreeNode parent) {
        TreeNode child = parent.left;
        TreeNode subTree = child.right;
        child.right= parent;
        parent.left = subTree;

        child.height = Math.max(height(child.right), height(child.left)) + 1;
        parent.height = Math.max(height(parent.right), height(parent.left)) + 1;

        return child;
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

    public boolean isEmpty() {
        return root == null;
    }

    public int height() {
        return this.height(this.root);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean balanced() {
        return balanced(root);
    }

    public boolean balanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1
                && balanced(node.left)
                && balanced(node.right);
    }

    public void display() {
        BinaryTreePrinter.printTree(this.root);
    }
}
