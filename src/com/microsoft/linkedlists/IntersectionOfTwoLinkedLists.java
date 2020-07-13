package com.microsoft.linkedlists;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(8);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(1);
        listNode1.next.next.next = new ListNode(8);
        listNode1.next.next.next.next = new ListNode(4);
        listNode1.next.next.next.next.next = new ListNode(5);

        ListNode.printListNode(getIntersectionNode(listNode,listNode1));

    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode aPointer = headA;
        ListNode bPointer = headB;

        while (aPointer != bPointer) {
            if(aPointer ==null){
                aPointer = headB;
            }else{
                aPointer = aPointer.next;
            }
            if(bPointer ==null){
                bPointer = headA;
            }else {
                bPointer = bPointer.next;
            }
        }

        return aPointer;
    }
}
