package com.microsoft.treesandgraphs;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(-2);

        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(7);
        tree.left.right = new TreeNode(8);

        if (isValidBST(tree))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double left_child_value = -Integer.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= left_child_value) return false;
            left_child_value = root.val;
            root = root.right;

        }

        return true;
    }
}
