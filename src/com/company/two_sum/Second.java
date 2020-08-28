package com.company.two_sum;

import java.util.HashMap;
import java.util.Map;

public class Second {
    // 哈希对撞
    // 空间复杂度O(1)
    //时间复杂度O(nums.length)
    public int[] solution1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};

            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
