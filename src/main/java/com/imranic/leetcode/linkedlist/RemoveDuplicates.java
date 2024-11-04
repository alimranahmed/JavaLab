package com.imranic.leetcode.linkedlist;

// 83. Remove Duplicates from Sorted List
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addLast(1);
        head.addLast(2);
        head.addLast(3);
        head.addLast(3);
        head = (new RemoveDuplicates()).deleteDuplicates(head);
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val+" -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;

        while(node.next != null) {
            if(node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
