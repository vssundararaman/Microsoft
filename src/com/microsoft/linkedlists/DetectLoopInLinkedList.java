package com.microsoft.linkedlists;

public class DetectLoopInLinkedList {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }


    public static void main(String[] args) {

        DetectLoopInLinkedList list = new DetectLoopInLinkedList();
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;

        System.out.println(detectLoop(head));
    }

    static boolean detectLoop(Node node){

        Node slow = node; Node fast = node;

        while(slow!=null && fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow==fast){
                    return true;
                }
        }

        return false;
    }


    static void print(Node node){
        while (node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}


