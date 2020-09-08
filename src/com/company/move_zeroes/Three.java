package com.company.move_zeroes;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//示例:
//
//输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
public class Three {
    public void solution1(int[] nums) {
        int p1 = 0;//可存放非零元素的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1++;
            }
        }
    }
}
