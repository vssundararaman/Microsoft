package com.microsoft.linkedlists;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(6);

        ListNode[] listNodes = {listNode,listNode1,listNode2};

        ListNode.printListNode(mergeKLists(listNodes));
    }

    static ListNode mergeKLists(ListNode[] lists){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(ListNode head: lists){
            while(head!=null){
                minHeap.add(head.val);
                head = head.next;
            }
        }

        ListNode listNode = new ListNode(-1);
        ListNode head = listNode;

        while(!minHeap.isEmpty()){
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }

        return listNode.next;
    }

}


