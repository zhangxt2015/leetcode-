package com.company.merge_sorted_array;

public class Second {
    //合并数组nums1 和 nums2
    //时间复杂度O(m+n)
    //空间复杂度O(m)
    public void solution1(int[] nums1, int m, int[] nums2, int n) {
        // 将nums1复制到nums1_copy
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0;
        int p2 = 0;
        int index = 0;

        // 将nums1_copy 和nums2交替写入nums1
        while (p1 < m && p2 < n) {
            nums1[index++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }

        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }

        if (p2 < n) {
            System.arraycopy(nums2, p2,  nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    //归并-从大到小
    //时间复杂度O(m+n)
    //空间复杂度O(1)
    public void solution2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        int index = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[index--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2];
        }

        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
}
