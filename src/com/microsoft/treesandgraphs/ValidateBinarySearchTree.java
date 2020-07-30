package com.microsoft.treesandgraphs;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(4);

        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(1);
        tree.right.right = new TreeNode(8);

        if (isValidBST(tree))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

        if(isValidBinarySearchTree(tree))
            System.out.println("IS BST 2nd Method");
        else
            System.out.println("Not a BST 2nd Method");
    }

    static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double left_child_value = -Integer.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop ();
            if (root.val <= left_child_value) return false;
            left_child_value = root.val;
            root = root.right;

        }

        return true;
    }

    static boolean isValidBinarySearchTree(TreeNode root){

        if(root ==null) return true;
        return isValidBinarySearchTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    static boolean isValidBinarySearchTree(TreeNode root, Long min, Long max) {
        if(root == null)return true;

        if(root.val <= min ||root.val >= max) return false;

        return isValidBinarySearchTree(root.left, min, Long.valueOf(root.val)) &&
                isValidBinarySearchTree(root.right,Long.valueOf(root.val), max);
    }

}
