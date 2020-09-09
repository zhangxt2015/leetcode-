package com.company.trapping_rain_water;

// 接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 数组每一个节点可接的雨水=min(max(左数组), max(右数组));
public class Three {
    // 循环数组，寻找每一个节点的left_max和right_max，min(left_max, right_max)和当前元素相减，得到目标值
    // 时间复杂度O(n^2)
    // 空间复杂度O(1)

    // 时间复杂度可以优化
    public int solution1(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int max_left = 0;
            int max_right = 0;
            for (int j = i; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }

            for (int j = i; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }

            total += Math.min(max_left, max_right) - height[i];
        }
        return total;
    }

    // 优化查询left_max和right_max的过程

    // 使用2n的时间复杂度将left_max right_max保存到数组中
    // 时间复杂度O(n)
    // 空间复杂度O(n)

    // 待优化的点 空间复杂度
    public int solution2(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int[] left_max_arr = new int[height.length];
        int[] right_max_arr = new int[height.length];

        left_max_arr[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left_max_arr[i] = Math.max(height[i], left_max_arr[i - 1]);
        }

        right_max_arr[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right_max_arr[i] = Math.max(height[i], right_max_arr[i + 1]);
        }

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            total += Math.min(left_max_arr[i], right_max_arr[i]) - height[i];
        }
        return total;
    }

    public int solution3(int[] height) {
        int max_left = 0;
        int max_right = 0;
        int p1 = 0;
        int p2 = height.length - 1;
        int total = 0;

        while (p1 < p2) {
            if (height[p1] < height[p2]) {// 短板在左边p1处
                if (height[p1] > max_left) {
                    max_left = height[p1];
                } else {
                    total += max_left - height[p1];
                }
                p1++;
            } else { //短板在p2 右边
                if (height[p2] > max_right) {
                    max_right = height[p2];
                } else {
                    total += max_right - height[p2];
                }
                p2--;
            }
        }
        return total;
    }
}
