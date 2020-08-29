package com.company.move_zeroes;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
public class First {
    //双指针 循环快指针，检测到非零元素时，和慢指针对应的元素进行交换，慢指针++
    //时间复杂度O(n)
    //空间复杂度O(1)
    public void solutions1(int[] nums) {
        int point1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[point1];
                nums[point1] = nums[i];
                nums[i] = temp;
                point1++;
            }
        }
    }
}
