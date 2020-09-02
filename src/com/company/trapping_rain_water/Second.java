package com.company.trapping_rain_water;

// 接雨水
// 由非负数组成的数组，构建一个柱状图，求柱状图的水容量

// 分析
// 1 先求出数组每个节点所能容纳的水容量
//      每个节点的水容量取决于 min(左侧节点的最大值, 右侧节点最大值)
// 2 对每个节点的水容量求和
public class Second {
    // 暴力
    //时间复杂度：O(n^2)
    //空间复杂度：O(1)

    //待优化
    //  q:每一次寻找左/右最大值时，数组都被完整扫描一遍
    //  a:扫一次，将左/右最大值记录下来
    public int solution1(int[] height) {
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int left_max = 0;
            int right_max = 0;
            for (int j = i; j >= 0; j--) {
                if (height[j] > left_max) {
                    left_max = height[j];
                }
            }

            for (int j = i; j < height.length; j++) {
                if (height[j] > right_max) {
                    right_max = height[j];
                }
            }

            total += Math.min(left_max, right_max) - height[i];
        }
        return total;
    }

    // 动态规划，
    // 动态规划数组的第n个节点保存前n个元素的最大值
    // 时间复杂度O(n)
    // 空间复杂度O(n)

    //待优化的点
    // 空间复杂度还能优化，尝试双指针
    public int solution2(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] left_max_arr = new int[height.length];
        int[] right_max_arr = new int[height.length];

        left_max_arr[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left_max_arr[i] = Math.max(left_max_arr[i - 1], height[i]);
        }

        right_max_arr[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right_max_arr[i] = Math.max(right_max_arr[i + 1], height[i]);
        }

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            total += Math.min(left_max_arr[i], right_max_arr[i]) - height[i];
        }
        return total;
    }

    public int solution3(int[] height) {
        if (height.length < 1) {
            return 0;
        }

        // 初始化左右指针
        int left = 0;
        int right = height.length - 1;

        // 初始化左右最大值
        int left_max = 0;
        int right_max = 0;

        int total = 0;
        while (left < right) {
            if (height[left] < height[right]) {// 较大值在右边,节点的水容量取决于左边界
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    total += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    total += right_max - height[right];
                }
                right--;
            }
        }
        return total;
    }
}
