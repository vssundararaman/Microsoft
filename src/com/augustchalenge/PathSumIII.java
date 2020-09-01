package com.augustchalenge;

import com.microsoft.design.TreeNode;

public class PathSumIII {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode (10);

        tree.left = new TreeNode (5);
        tree.right = new TreeNode (-3);
        tree.right.right = new TreeNode (11);
        tree.left.left = new TreeNode (3);
        tree.left.right = new TreeNode (2);
        tree.left.right.right = new TreeNode (1);
        tree.left.left.left = new TreeNode (3);
        tree.left.left.right = new TreeNode (-2);

        System.out.println (pathSum(tree, 8));
    }

    static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath (root, sum) + pathSum (root.left, sum) + pathSum (root.right, sum);
    }

    static int findPath(TreeNode root, int sum) {
        int result = 0;
        if (root == null) {
            return result;
        }

        if (sum == root.val) {
            result++;
        }

        result += findPath (root.left, sum - root.val);
        result += findPath (root.right, sum - root.val);
        return result;
    }
}
