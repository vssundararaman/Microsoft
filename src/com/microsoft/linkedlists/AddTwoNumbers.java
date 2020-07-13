package com.microsoft.linkedlists;

import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
/*        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);*/

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
/*        listNode1.next.next = new ListNode(4);
        listNode1.next.next.next = new ListNode(9);*/

        printListNode(addTwoNumbers(listNode, listNode1));
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = l1, q = l2, curr = head;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }

    static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode p = l1, q = l2, curr = head;

        int carry = 0;

        while (p != null || q != null) {

            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = carry + x + y;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;

            if (q != null) q = q.next;

        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }

    static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}

