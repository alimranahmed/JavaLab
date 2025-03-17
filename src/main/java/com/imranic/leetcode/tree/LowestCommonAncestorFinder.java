package com.imranic.leetcode.tree;

import com.imranic.algorithms.tree.BinarySearchTree;
import com.imranic.algorithms.tree.TreeNode;

public class LowestCommonAncestorFinder {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.populate(new int[]{6, 2, 8, 0, 4, 7, 9, 3, 5});

        LowestCommonAncestorFinder lcaFinder = new LowestCommonAncestorFinder();
        bst.display();
        TreeNode lca = lcaFinder.lowestCommonAncestor(bst.getRoot(), bst.root.left, bst.getRoot().right);
        System.out.println(lca.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }
}
