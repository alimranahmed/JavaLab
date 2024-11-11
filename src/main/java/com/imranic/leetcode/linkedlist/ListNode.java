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

    public ListNode addLast(int val) {
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(val);
        return node.next;
    }

    public void print() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val+" -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    @Override
    public String toString() {
        return ""+this.val;
    }
}