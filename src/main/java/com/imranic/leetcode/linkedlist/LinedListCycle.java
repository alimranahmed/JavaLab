package com.imranic.leetcode.linkedlist;

// 141. Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/
public class LinedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = head.addLast(2);
        head.addLast(0);
        ListNode node1 = head.addLast(-4);
        node1.next = node;
        boolean hasCycle = new LinedListCycle().hasCycle(head);
        System.out.println(hasCycle);
    }

    // We use "fast and slow pointer" or "hare and tortoise" technique
    // The idea is: if two people(1 fast and 1 slow) walk in a non-circular road
    // If they start from the same point same time, then they will never meet
    // as one is fast another one is slow.
    // But if the road is circular, the road will never end
    // and faster person will meet the slower person at one point.
    // Thus, we can do the same for finding a cycle in a linked list.
    // If we start two pointers(fast and slow point)
    // one move by one another one move by two nodes each step
    // If the fast pointer meets the slow pointer then it's a cycle
    // If the loop ends and fast and slow pointers don't meet each other
    // There is no cycle
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
