package com.imranic.leetcode.linkedlist;

public class Reorderer {
    public static void main(String[] args) {
        ListNode head = ListNode.of(new int[]{1, 2, 3, 4});

        (new Reorderer()).reorderList(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = this.getMid(head);
        ListNode tail = this.reverse(mid);
        ListNode current = head;

        while (tail != null && current != null) {
            ListNode temp = current.next;
            current.next = tail;
            current = temp;

            temp = tail.next;
            tail.next = current;
            tail = temp;
        }
        if (current != null) {
            current.next = null;
        }
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode reversed = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
        }
        return reversed;
    }
}
