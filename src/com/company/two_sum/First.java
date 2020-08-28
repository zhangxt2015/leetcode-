package com.company.two_sum;

import java.util.HashMap;
import java.util.Map;

public class First {
    // 哈希对撞法
    //时间复杂度O(m)
    //空间复杂度O(m)
    public int[] solution1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
