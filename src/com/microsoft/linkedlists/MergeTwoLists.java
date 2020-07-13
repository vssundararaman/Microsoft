package com.microsoft.linkedlists;

public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);

        ListNode.printListNode(mergeTwoLists(listNode, listNode1));

        ListNode.printListNode(mergeTwoLists1(listNode, listNode1));
    }

    static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

/*
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;

        }else{
            l2.next = mergeTwoLists1(l1,l2.next);
            return l2;
        }*/
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}
