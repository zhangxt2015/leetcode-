package com.company.merge_two_sorted_lists;

public class Three {
    // 归并
    // 将两个连标归并到一个新链表中
    public ListNode solution1(ListNode l1, ListNode l2) {
        ListNode new_node = new ListNode(-1);
        ListNode a = new_node;//记录起点，方便最后函数返回
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                new_node.next = l2;
                l2 = l2.next;
            } else {
                new_node.next = l1;
                l1 = l1.next;
            }
            new_node = new_node.next;//即时更新new_node
        }

        new_node.next = l1 != null ? l1 : l2;
        return a.next;
    }

    // 递归
    public ListNode solution2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = solution2(l1.next, l2);
            return l1;
        } else {
            l2.next = solution2(l2.next, l1);
            return l2;
        }
    }
}
