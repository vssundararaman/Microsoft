package com.amazon.treesandgraphs;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode (1);

        tree.left = new TreeNode (2);
        tree.right = new TreeNode (2);
        tree.left.left = new TreeNode (4);
        tree.left.right = new TreeNode (5);
        tree.right.right = new TreeNode (4);
        tree.right.left = new TreeNode (5);

        System.out.println (isSymmetric (tree));
    }

    static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isSymmetric (root.left, root.right);
    }

    static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetric (left.left, right.right) && isSymmetric (left.right, right.left);
    }
}
