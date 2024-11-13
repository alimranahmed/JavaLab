package com.imranic.leetcode.linkedlist;

// 61. Rotate List
// https://leetcode.com/problems/rotate-list
public class RotateKElements {
    public static void main(String[] args) {
        ListNode head = ListNode.of(new int[]{1, 2, 3, 4, 5});
        ListNode rotated = (new RotateKElements()).rotateRight(head, 2);
        rotated.print();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        ListNode last = head;
        // Find the length and last node
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;

        int rotations = k % length; // rotating length times results same linked list
        int skip = length - rotations;
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
        return head;
    }
}
