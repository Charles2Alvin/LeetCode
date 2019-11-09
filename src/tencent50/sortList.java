package tencent50;

import datastructure.ListNode;

class sortList {
    public ListNode sortList(ListNode head) {
        // 计算列表长度
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        ListNode ret = new ListNode(0);
        ret.next = head;
        int interval = 1;
        // 归并排序
        while (interval < length) {
            ListNode pre = ret, h = ret.next;
            while (h != null) {
                // 先找到两个子链表的头部
                ListNode h1 = h;
                int i = interval;
                while (i != 0 && h != null) {
                    i--;
                    h = h.next;
                }
                if (i != 0) break; // 此时h2为空
                ListNode h2 = h;
                i = interval;
                while (i != 0 && h != null) {
                    i--;
                    h = h.next;
                }
                int len1 = interval, len2 = interval - i;
                while (len1 != 0 && len2 != 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        len1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        len2--;
                    }
                    pre = pre.next;
                }
                pre.next = len1 != 0? h1 : h2;
                while (len1 > 0 || len2 > 0) {
                    pre = pre.next;
                    len1--;
                    len2--;
                }
                pre.next = h;
            }
            interval *= 2;
        }
        return ret.next;
    }
}