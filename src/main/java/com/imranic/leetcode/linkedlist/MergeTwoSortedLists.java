package com.imranic.leetcode.linkedlist;

import java.util.List;

// 21. Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.addLast(2);
        list1.addLast(4);

        ListNode list2 = new ListNode(1);
        list2.addLast(3);
        list2.addLast(4);

        ListNode mergedList = new MergeTwoSortedLists()
                .mergeTwoLists(list1, list2);

        mergedList.print();
    }

    /**
     * As the lists are sorted we travers throw both list until any of them are null
     * For each list we check val of one list with the val of another list
     * We add the value of list that contains smaller value and move forward
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 == null) ? list2 : list1;

        return newHead.next;
    }
}
