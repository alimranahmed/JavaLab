package com.imranic.leetcode.linkedlist;

// 92. Reverse Linked List II
// https://leetcode.com/problems/reverse-linked-list-ii
public class LinkedListReverseII {
    public static void main(String[] args) {
        LinkedListReverseII reverser = new LinkedListReverseII();

        ListNode head = ListNode.of(new int[]{1, 2, 3, 4, 5});
        head.print();
        ListNode reversedHead = reverser.reverseBetween(head, 2, 4);
        reversedHead.print();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // Skip the first left -1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;
        // Reverse between left and right
        for (int i = 0; current != null && i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if (last != null) {
            last.next = prev;;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }
}
