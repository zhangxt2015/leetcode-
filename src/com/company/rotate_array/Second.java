package com.company.rotate_array;

//旋转数组
public class Second implements interfaces {
    //向右移动1个位置，移动k次
    @Override
    public void solution1(int[] nums, int k) {
        for (int j = 0; j < k; j++) {
            int current = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = current;
                current = temp;
            }
        }
    }

    //每个元素向右移动k次
    // 时间复杂度 O(nums.length)
    // 空间复杂度 O(nums.length)
    @Override
    public void solution2(int[] nums, int k) {
        k = k % nums.length;
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(a, 0, nums, 0, nums.length);
    }

    //环状替换-双重循环，内循环每次向右移动k，直到回到原点。统计移动次数到达nums.length 外循环终止
    //
    public void solution3(int[] nums, int k) {
        int count = 0;
        k = k % nums.length;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[current];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (current != start);
        }
    }
}
