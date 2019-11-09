package tencent50;

import datastructure.ListNode;

public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return null;
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        int shift = n > k ? n - k : n - k % n;
        while (shift-- != 0) {
            ListNode second = head.next;
            tail.next = head;
            head.next = null;
            tail = head;
            head = second;
        }
        return head;
    }
}
