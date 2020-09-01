package com.company.trapping_rain_water;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class First {
    // 分别计算数组每一个下标所能容纳的水
    // 针对每一个数组下标，查询left_max 和 right_max， min(left_max, right_max) - height[i]；

    // 时间复杂度 O(n^2)
    // 空间复杂度 O(1)

    // 待优化的点
    // 每一对left_max 和 right_max 都被计算了n次
    public int solution1(int[] height) {
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left_max = 0;
            int right_max = 0;
            for (int j = i; j >= 0; j--) {
                left_max = max(left_max, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                right_max = max(right_max, height[j]);
            }
            total += min(left_max, right_max) - height[i];
        }
        return total;
    }

    // 动态规划
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)

    //待优化
    //动态规划的空间复杂度可以使用双指针优化
    public int solution2(int[] height) {
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];

        // 计算每个数组下标的左侧最大值，保存到left_max数组
        left_max[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left_max[i] = max(height[i], left_max[i - 1]);
        }

        // 计算每个数组下标的右侧最大值，保存到right_max数组
        right_max[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right_max[i] = max(height[i], right_max[i + 1]);
        }

        int total = 0;
        // 计算每一个下标的最大容纳量，min(left_max, right_max) - height[i]
        for (int i = 1; i < height.length - 1; i++) {
            total += min(left_max[i], right_max[i]) - height[i];
        }
        return total;
    }

    // 每一个数组下标对应的蓄水量取决于 left_max和right_max的较小值
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public int solution3(int[] height) {
        // 初始化左右指针，用来遍历数组
        int left = 0;
        int right = height.length - 1;

        // 初始化左右最大值
        int left_max = 0;
        int right_max = 0;

        int total = 0;
        while (left < right) {
            if (height[left] < height[right]) {// 左边界的值小于右边界值时，高的一面在右边，蓄水量由左边值决定
                if (height[left] > left_max) {// 指定下标的值替换max
                    left_max = height[left];
                } else {//指定的下标值小于max时，开始蓄水
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
