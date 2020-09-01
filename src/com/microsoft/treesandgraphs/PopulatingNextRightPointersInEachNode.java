package com.microsoft.treesandgraphs;

public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {

        Node left = new Node(2,new Node(), new Node(),new Node());
        Node right = new Node(3,new Node(), new Node(),new Node());
        Node tree = new Node(1, left, right, new Node());


        System.out.println (Connect (tree));
    }

    static Node Connect(Node root) {
        Node leftNode = root;

        while (leftNode!=null && leftNode.left!=null){
            populateLowerLevel(leftNode);
            leftNode = leftNode.left;
        }

        return root;
    }

    private static void populateLowerLevel(Node startNode) {
        Node iteratedNode = startNode;

        while (iteratedNode!=null){
            iteratedNode.left.next = iteratedNode.right;
            if(iteratedNode.next !=null)
                iteratedNode.right.next = iteratedNode.left;
            iteratedNode = iteratedNode.next;
        }

    }
}


