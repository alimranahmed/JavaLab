package com.imranic.algorithms.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public int height;

    public TreeNode(int value) {
        this.val = value;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
