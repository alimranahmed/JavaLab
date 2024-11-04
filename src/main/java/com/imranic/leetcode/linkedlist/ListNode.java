package com.imranic.leetcode.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void addLast(int val) {
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(val);
    }
}
