package com.augustchalenge;

import com.microsoft.design.TreeNode;

public class ClosestBinarySearchTreeValue {

    static int goal;
    static double min = Double.MAX_VALUE;

    public static void main(String[] args) {

        TreeNode tree = new TreeNode (4);

        tree.left = new TreeNode (2);
        tree.right = new TreeNode (5);
        tree.left.left = new TreeNode (1);
        tree.right.right = new TreeNode (3);

        System.out.println (closestValue (tree, 1.21232));
    }

    static int closestValue(TreeNode root, double target){
        helper(root, target);
        return goal;
    }

    static void helper(TreeNode root, double target){
        if(root ==null){
            return;
        }

        if(Math.abs (root.val - target) < min){
            min = Math.abs (root.val - target);
            goal =  root.val;
        }

        if(target < root.val){
            helper (root.left,target);
        }else{
            helper (root.right, target);
        }
    }
}

