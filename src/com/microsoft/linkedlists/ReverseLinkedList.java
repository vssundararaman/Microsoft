package com.microsoft.linkedlists;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);
        /*list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next.next = new ListNode(7);
        list.next.next.next.next.next.next.next.next = new ListNode(8);*/

        //printNode(list);

        reverseList(list);

       // reverseIterativeList(list);

        printNode(list);
    }

    static ListNode reverseIterativeList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    static ListNode reverseList(ListNode head){
        if (head == null || head.next == null)
            return head;

        /* reverse the rest list and put
        the first element at the end */
        ListNode rest = reverseList(head.next);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

    static void printNode(ListNode node){
        while (node !=null){
            System.out.print (node.data + ", ");
            node = node.next;
        }
    }
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            next = null;
        }
    }
}
