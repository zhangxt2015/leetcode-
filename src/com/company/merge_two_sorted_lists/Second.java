package com.company.merge_two_sorted_lists;

public class Second {
    // 归并-递归
    // 时间复杂度O(l1.length+l2.length)
    // 空间复杂度，递归调用会消耗栈空间，至多递归调用(l1.length+l2.length)次
    public ListNode solution1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = solution1(l1.next, l2);
            return l1;
        } else {
            l2.next = solution1(l2.next, l1);
            return l2;
        }
    }

    // 归并-迭代
    public ListNode solution2(ListNode l1, ListNode l2) {
        ListNode a = new ListNode(-1);
        ListNode prev = a;
        while (l1 != null & l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return a.next;
    }
}
