package com.company.merge_sorted_array;

// 归并两个数组
public class Three {
    //将两个数组归并到一个新数组 并返回
    //空间复杂度可以再优化
    public void solution1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];

        int point1 = 0;
        int point2 = 0;
        int index = 0;
        while (point1 < m && point2 < n) {
            nums1_copy[index++] = nums1[point1] < nums2[point2] ? nums1[point1++] : nums2[point2++];
        }

        if (point1 < m) {
            System.arraycopy(nums1, point1, nums1_copy, index, m - point1);
        }

        if (point2 < n) {
            System.arraycopy(nums2, point2, nums1_copy, index, n - point2);
        }

        System.arraycopy(nums1_copy, 0, nums1, 0, m);
    }

    //将归并结果放入其中一个数组，不需要额外的空间
    public int[] solution2(int[] nums1, int m, int[] nums2, int n) {

    }
}
