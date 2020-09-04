package com.company.merge_sorted_array;

// 归并两个数组
public class Three {
    //将两个数组归并到一个新数组 并返回
    //空间复杂度可以再优化
    public void solution1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int point1 = 0;
        int point2 = 0;
        int index = 0;
        while (point1 < m && point2 < n) {
            nums1[index++] = nums1_copy[point1] < nums2[point2] ? nums1_copy[point1++] : nums2[point2++];
        }

        if (point1 < m) {
            System.arraycopy(nums1_copy, point1, nums1, index, m - point1);
        }

        if (point2 < n) {
            System.arraycopy(nums2, point2, nums1, index, n - point2);
        }
    }

    //将归并结果放入其中一个数组，不需要额外的空间
    public void solution2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        //循环比较两个数组的最大值
        // 写入nums1末尾
        while (p1 >= 0 && p2 >= 0) {
            nums1[index--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, index + 1);
        }
    }
}
