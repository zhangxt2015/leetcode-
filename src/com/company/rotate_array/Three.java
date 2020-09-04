package com.company.rotate_array;

public class Three implements interfaces {
    // 一次n次的循环把数组的所有元素移动一个位置，移动k次
    // 时间复杂度O(n*k)
    public void solution1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public void solution2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int prev = start;
            int prev_val = nums[prev];
            do {
                int next = nums[(prev + k) % nums.length];
                nums[(prev + k) % nums.length] = prev_val;
                prev_val = next;
                prev = (prev + k) % nums.length;
                count++;
            } while (start != prev);
        }
    }
}
