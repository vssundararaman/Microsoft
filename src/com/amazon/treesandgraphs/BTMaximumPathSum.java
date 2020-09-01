package com.amazon.treesandgraphs;

public class BTMaximumPathSum {

    static int max_PathSum;

    public static void main(String[] args) {
        TreeNode tree = new TreeNode (-10);

        tree.left = new TreeNode (9);
        tree.right = new TreeNode (20);
        tree.right.right = new TreeNode (7);
        tree.right.left = new TreeNode (15);

        System.out.println (maxPathSum (tree));
    }

    static int maxPathSum(TreeNode root) {
        max_PathSum = Integer.MIN_VALUE;
        pathSum (root);
        return max_PathSum;
    }

    static int pathSum(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max (0, pathSum (node.left));
        int right = Math.max (0, pathSum (node.right));
        max_PathSum = Math.max (max_PathSum, left + right + node.val);
        return Math.max (left, right) + node.val;
    }
}
