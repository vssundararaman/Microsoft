package com.microsoft.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4);

        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(1);
        tree.right.right = new TreeNode(8);

        System.out.println (inOrderTraversal (tree));
    }

    static List<Integer> inOrderTraversal(TreeNode Node) {

        List<Integer> result = new ArrayList<> ();
        helper (Node, result);
        return result;
    }

    static void helper(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null) {
                helper (node.left, list);
            }
            list.add (node.val);
            if (node.right != null) {
                helper (node.right, list);
            }
        }
    }
}
