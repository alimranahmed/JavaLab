package com.imranic.leetcode.linkedlist;

// 142. Linked List Cycle II
// https://leetcode.com/problems/linked-list-cycle-ii
public class LinedListCycleI2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = head.addLast(2);
        head.addLast(0);
        ListNode node1 = head.addLast(-4);
        node1.next = node;
        ListNode startOfCycle = new LinedListCycleI2().detectCycle(head);
        System.out.println("Cycle starts at: "+startOfCycle.val);
    }

    // This is solved on top of the knowledge of finding if any cycle exists or not
    // If slow == fast, there is cycle
    // Slow was moving by 1 and fast was moving by 2 node speed
    // When slow reach the cycle-start node, let's say the length from start to cycle-start node is d
    // When slow reach d, fast reach 2d
    // Then the both rounding in the cycle.
    // So, slow is running away from fast with 1, and fast is running towards slow with 2
    // Thus the speed they were reach to each other was at 1
    // Which means when they meat each other from that meeting-node to cycle-start is
    // Equal to the distance from start to cycle-start
    // Thus we start another 2 pointers, we reposition slow to start
    // At that time fast is at meeting-node
    // We increase both slow and fast and they should meet at the cycle-start node
    // Video explanation: https://www.youtube.com/watch?v=2Kd0KKmmHFc
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Cycle exists
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
