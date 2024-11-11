package com.imranic.leetcode.linkedlist;

// 148. Sort List
// https://leetcode.com/problems/sort-list
public class SortLinkList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.addLast(2);
        head.addLast(1);
        head.addLast(3);

        SortLinkList sl = new SortLinkList();

        ListNode sortedHead = sl.sortList(head);
        sortedHead.print();
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = this.getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return this.merge(right, left);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode newHead = new ListNode();
        ListNode current = newHead;
        while(left != null && right != null) {
            if (left.val < right.val ) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        current.next = left == null ? right : left;

        return newHead.next;
    }


    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = null;

        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return mid;
    }
}
