package com.imranic.leetcode.tree;

import com.imranic.algorithms.tree.TreeNode;

// 110. Balanced Binary Tree
// https://leetcode.com/problems/balanced-binary-tree
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        return Math.abs(heightDiff) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
