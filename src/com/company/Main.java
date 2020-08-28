package com.company;

import com.company.rotate_array.Second;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] count1 = {11, 2, 3, 4, 5};
        int[] count2 = {11, 2, 3, 4, 5};
        int[] count3 = {11, 2, 3, 4, 5};

        Second second = new Second();
        second.solution1(count1, 2);
        second.solution2(count2, 2);
        second.solution3(count3, 2);

//        ListNode l1 = new ListNode();
//        ListNode l2 = new ListNode();
//        ListNode cc = mergeTwoLists(l1, l2);
        System.out.println(Arrays.toString(count1));
        System.out.println(Arrays.toString(count2));
        System.out.println(Arrays.toString(count3));
//        System.out.println(Arrays.toString(count));
    }

    //归并-迭代
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode header = new ListNode(-1);
//        ListNode prev = header;
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                prev.next = l1;
//                l1 = l1.next;
//            } else {
//                prev.next = l2;
//                l2 = l2.next;
//            }
//            prev = prev.next;
//        }
//        prev.next = l1 == null ? l2 : l1;
//        return header.next;
//    }

    // 归并-递归
    //空间复杂度O(m+n) m和n分别是两个链表的长度，递归调用mergeTwoLists消耗栈空间
    //时间复杂度O(m+n) 最多执行m+n次mergeTwoLists()
//    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        } else if (l2 == null) {
//            return l1;
//        } else if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }

    // 暴力1
    // 时间复杂度O(k*n)
    // 空间复杂度O(1)
//    public static void rotate1(int[] nums, int k) {
//        Second.test(nums, k);
//    }


    //暴力2
//    public static void rotate(int[] nums, int k) {
//        int[] new_nums = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            new_nums[(i + k) % nums.length] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = new_nums[i];
//        }
//    }

















    // 双重循环
//    public static void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        int count = 0;//记录移动元素的个数
//        for (int start = 0; count < nums.length; start++) {
//            int current = start;
//            int prev = nums[current];
//            do {
//                int next = (current + k) % nums.length;
//                int temp = nums[next];
//                nums[next] = prev;
//                current = next;
//                prev = temp;
//                count++;
//            } while (current != start);
//        }
//    }
























    // 循环替换
    // 双重循环
    // 内循环的终止条件是 current=start
    // 外循环的终止条件是移动元素的个数等于数组长度
//    public static void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        int count = 0;
//        for (int start = 0; count < nums.length; start++) {
//            int current = start;
//            int prev = nums[start];
//            do {
//                int next = (current + k) % nums.length;
//                int temp = nums[next];
//                nums[next] = prev;
//                prev = temp;
//                current = next;
//                count++;// 记录总的移动次数，上限是数组的长度
//            } while (current != start);
//        }
//    }


//    public static void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        int count = 0;
//        for (int start = 0; count < nums.length; start++) {
//            int current = start;
//            int prev = nums[start];
//            do {
//                int next = (current + k) % nums.length;
//                int temp = nums[next];
//                nums[next] = prev;
//                prev = temp;
//                current = next;
//                count++;
//            } while (start != current);
//        }
//    }

}
