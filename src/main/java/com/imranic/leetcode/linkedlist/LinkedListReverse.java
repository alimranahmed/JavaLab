package com.imranic.leetcode.linkedlist;

// https://leetcode.com/problems/reverse-linked-list
// 206. Reverse Linked List
public class LinkedListReverse {
    public static void main(String[] args) {
        LinkedListReverse reverser = new LinkedListReverse();

        ListNode head = ListNode.of(new int[]{1, 3, 4, 5});
        head.print();

        ListNode reversedHead = reverser.reverseList(head);
        //ListNode reversedHead = reverser.reverseListByRecursion(head);

        reversedHead.print();
    }

    // This is in place reversal
    // Let's say we have a lined list: null -> 1 -> 2 -> 3 -> 4 -> 5
    // What we are doing is:
    // 1st step: null <- 1 and 2 ->  3 -> 4 -> 5
    // 2nd step: null <- 1 <- 2 and 3 -> 4 -> 5
    // Basically, we are reversing the link and moving the current forward
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
