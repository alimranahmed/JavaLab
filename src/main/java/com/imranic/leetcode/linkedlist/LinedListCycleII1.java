package com.imranic.leetcode.linkedlist;

// 142. Linked List Cycle II
// https://leetcode.com/problems/linked-list-cycle-ii
public class LinedListCycleII1 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = head.addLast(2);
        head.addLast(0);
        ListNode node1 = head.addLast(-4);
        node1.next = node;
        ListNode startOfCycle = new LinedListCycleII1().detectCycle(head);
        System.out.println("Cycle starts at: "+startOfCycle.val);
    }

    // This is build on top of the knowledge of finding if any cycle exists or not
    // If there is a cycle then we find the length of the cycle
    // Then we start another 2 pointers
    public ListNode detectCycle(ListNode head) {
        int length = this.findLengthOfCycle(head);

        // Length 0 means no cycle returns
        if (length == 0) {
            return null;
        }

        // Find the first node
        ListNode first = head;
        ListNode second = head;
        while (length > 0) {
            second = second.next;
            length--;
        }
        // keep moving both forward and they will meet at cycle start
        while(first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    // When we know there is a cycle(fast == slow)
    // Fast and slow pointer meeting each other inside a path of circle.
    // There if the fast pointer stops there and slow pointer continue to move
    // The steps the slow pointer takes to meet fast pointer again is th length of the circle
    public int findLengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // Cycle found
                // Put a marker in the meeting point(tempSlow)
                // Continue moving the slow pointer by one node
                // If the meet again, we have the length!
                int length = 0;
                ListNode tempSlow = slow;
                do {
                    tempSlow = tempSlow.next;
                    length++;
                } while (tempSlow != slow);
                return length;
            }
        }
        return 0;
    }
}
