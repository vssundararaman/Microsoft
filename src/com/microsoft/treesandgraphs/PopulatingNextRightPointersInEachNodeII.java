package com.microsoft.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        System.out.println ("Executing...");
    }

    static Node connect(Node root){

        if(root ==null)return root;


        Queue<Node> queue = new LinkedList<> ();
        queue.add (root);

        while(queue.size () > 0){
            int size = queue.size ();

            for(int i= 0; i< size; i++){
                Node node = queue.poll ();


                if(i<size-1){
                    node.next = queue.peek ();
                }

                if(node.left!=null){
                    queue.add (node.left);
                }

                if(node.right!=null){
                    queue.add (node.right);
                }
            }
        }
        return root;
    }
}


