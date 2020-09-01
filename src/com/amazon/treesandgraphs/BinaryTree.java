package com.amazon.treesandgraphs;

public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        insert(root, 2);
        insert(root, 4);
        insert(root, 8);
        insert(root, 6);
        insert(root, 7);
        insert(root, 3);
        insert(root, 9);
        System.out.println("Traversing tree in order");
        traverseInOrder(root);
        System.out.println();
        System.out.println("Traversing tree Pre order");
        traversePreOrder (root);
        System.out.println();
        System.out.println("Traversing tree Post order");
        traversePostOrder (root);
    }

    static void insert(TreeNode node, int value) {
        if (value < node.val) {
            if (node.left != null) {
                insert (node.left, value);
            } else {
                //System.out.println (" Inserted " + value + " to left of " + node.val);
                node.left = new TreeNode (value);
            }
        } else if (value > node.val) {
            if (node.right != null) {
                insert (node.right, value);
            } else {
                //System.out.println ("  Inserted " + value + " to right of " + node.val);
                node.right = new TreeNode (value);
            }
        }
    }

    static void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder (node.left);
            System.out.print (" " + node.val);
            traverseInOrder (node.right);
        }
    }

    static void traversePreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(" " + node.val);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    static void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.val);
        }
    }
}
