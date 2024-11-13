package com.imranic.leetcode.linkedlist;

// 234. Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list
public class PalindromeChecker {
    public static void main(String[] args) {
        ListNode head = ListNode.of(new int[]{1, 2, 2, 1});
        boolean isPalindrome = (new PalindromeChecker()).isPalindrome(head);
        System.out.println(isPalindrome);
    }

    // The idea is:
    // Divide the linked list into two equal part and compare
    // 1. Find the mid of the linked list
    // 2. Reverse the part from mid
    // 3. Compare each element of 1st half and 2nd half
    // 4. If no mismatch found then it's a palindrome
    public boolean isPalindrome(ListNode head) {
        ListNode mid = this.getMid(head);
        ListNode head2 = this.reverseLinkedList(mid);
        while(head2 != null && head != null) {
            if (head.val != head2.val) {
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        return true;
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseLinkedList(ListNode head) {
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
