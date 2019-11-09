package tencent50;

import datastructure.ListNode;

public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
            双指针法：思路非常巧妙，两个链表相交，如果长度相同，只需顺序遍历，发现相同值返回即可；
            如果长度不同，必有一个先到尾部，这时将其重定向到另一个链表的头部，就抹去了长度的差别；
            如果相交，则重定向后必经一个节点使两指针内容相同；
            如不相交，会同时到达链表尾，此时返回null即可。
         */
        ListNode pA = headA, pB = headB;
        // 处理边界情况
        if (pA == null || pB == null) return null;
        while (true) {
            if (pA == pB) return pA;
            if (pA.next == null && pB.next == null) {
                return null;
            }
            pA = pA.next == null? headB : pA.next;
            pB = pB.next == null? headA : pB.next;
        }
    }

}