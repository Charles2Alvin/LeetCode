package tencent50;

import datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int interval = 1;
        int N = lists.length;
        if (N == 0) return null;
        while (interval < N) {
            for (int i = 0; i < N - interval; i += interval) {
                lists[i] = merge2Lists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    public ListNode merge2Lists(ListNode p1, ListNode p2) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                point.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                point.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            point = point.next;
        }
        if (p1 != null) {
            point.next = p1;
        } else point.next = p2;
        return head.next;
    }
}