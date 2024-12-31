package com.imranic.leetcode.tree;

import com.imranic.algorithms.tree.BinarySearchTree;
import com.imranic.algorithms.tree.BinaryTreePrinter;
import com.imranic.algorithms.tree.TreeNode;

// 226. Invert Binary Tree
// https://leetcode.com/problems/invert-binary-tree
public class InvertBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.populate(new int[]{4, 2, 7, 1, 3, 6, 9});
        BinaryTreePrinter.printTree(bst.getRoot());
        (new InvertBinaryTree()).invertTree(bst.getRoot());
        BinaryTreePrinter.printTree(bst.getRoot());
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
