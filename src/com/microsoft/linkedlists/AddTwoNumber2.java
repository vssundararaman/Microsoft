package com.microsoft.linkedlists;

import java.util.Stack;

public class AddTwoNumber2 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);

        ListNode.printListNode(addTwoNumbers(listNode, listNode1));
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 !=null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2!=null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode result = new ListNode(0);
        while(!s1.empty() || !s2.empty()){
            if(!s1.empty()){
                sum += s1.pop();
            }
            if(!s2.empty()){
                sum+=s2.pop();
            }
            result.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = result;
            result = head;
            sum /=10;
        }

        return result.val ==0 ?result.next : result;
    }

}
