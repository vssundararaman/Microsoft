package com.microsoft.treesandgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode (4);

        tree.left = new TreeNode (2);
        tree.right = new TreeNode (5);
        tree.left.left = new TreeNode (1);
        tree.right.right = new TreeNode (8);

        System.out.println (zigZagLevelOrder (tree));
    }

    static List<List<Integer>> zigZagLevelOrder(TreeNode node) {
        List<List<Integer>> result = new ArrayList<> ();

        if (node == null) return result;

        Stack<TreeNode> leftToRight = new Stack<> (); // Left To Right
        Stack<TreeNode> rightToLeft = new Stack<> (); // Right To Left

        //Root Node
        leftToRight.push (node);
        List<Integer> resultValues = new ArrayList<> ();

        while (!leftToRight.isEmpty () || !rightToLeft.isEmpty ()) {
            while (!leftToRight.isEmpty ()) {
                TreeNode leftNode = leftToRight.pop ();
                resultValues.add (leftNode.val);
                if (leftNode.left != null) {
                    rightToLeft.push (leftNode.left);
                }
                if (leftNode.right != null) {
                    rightToLeft.push (leftNode.right);
                }
            }

            if (!resultValues.isEmpty ())
                result.add (new ArrayList<> (resultValues));
            resultValues.clear ();

            while (!rightToLeft.isEmpty ()) {
                TreeNode rightNode = rightToLeft.pop ();
                resultValues.add (rightNode.val);
                if (rightNode.right != null) {
                    leftToRight.push (rightNode.right);
                }
                if (rightNode.left != null) {
                    leftToRight.push (rightNode.left);
                }
            }
            if (!resultValues.isEmpty ())
                result.add (new ArrayList<> (resultValues));
            resultValues.clear ();

        }
        return result;
    }
}
