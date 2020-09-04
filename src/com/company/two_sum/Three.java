package com.company.two_sum;

import java.util.HashMap;
import java.util.Map;

// 从数组中找出和为target的两个元素
public class Three {
    public int[] solution1(int[] nums, int target) {
        // 将nums依次放入map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //判断目标值是否在map中
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
