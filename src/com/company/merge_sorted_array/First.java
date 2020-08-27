package com.company.merge_sorted_array;

public class First {
    // 双指针，从前往后，从小到大
    // 时间复杂度O(m+n)
    // 空间复杂度O(m)
    public void solution1(int[] nums1, int m, int[] nums2, int n) {
        // 复制数组nums1
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int index = 0;
        // 初始化两个数组的指针
        int p1 = 0;
        int p2 = 0;
        // 比较nums1_copy和nums2的值，将较小的元素写入nums1
        while (p1 < m && p2 < n) {
            nums1[index++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }

        // 将剩余的nums1_copy或者nums2写入nums1
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    // 双指针，从后往前，从大到小
    //时间复杂度 O(m+n)
    //空间复杂度 O(1)
    public void solution2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int index = m + n - 1;

        // 比较nums1 和nums2的末尾元素，并将较大值写入nums1末尾
        while (p1 >= 0 && p2 >= 0) {
            nums1[index--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        // nums2数组剩余元素 写入nums1
        if (p2 >=0) {
            System.arraycopy(nums2, 0, nums1, 0, p2+1);
        }
    }
}
