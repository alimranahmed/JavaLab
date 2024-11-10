package com.imranic.leetcode.linkedlist;

// 876. Middle of the Linked List
// https://leetcode.com/problems/middle-of-the-linked-list/
public class MidOfLinkedList {
    public static void main(String[] args) {
        MidOfLinkedList midLinkedList = new MidOfLinkedList();

        ListNode head = new ListNode(1);
        head.addLast(2);
        head.addLast(3);
        head.addLast(4);
        head.addLast(5);
        head.addLast(6);

        ListNode mid = midLinkedList.middleNode(head);
        System.out.println(mid);
    }

    /**
     * The idea is, if we run slow and fast pointer
     * Slow pointer increase by 1 and fast pointer increase by 2
     * When the fast pointer reach the end of the linked list
     * The slow pointer is in the middle, we got the middle!
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
