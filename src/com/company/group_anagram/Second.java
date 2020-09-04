package com.company.group_anagram;

import java.util.*;

public class Second {
    // 把排序之后的字符串作为key放入map中，并将原字符串放入key对应的List中
    // 从map中取出数组
    public List<List<String>> solution1(String[] strs) {
        if (strs.length < 1) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //这一步是终点，将字符串转化为map的key
            //key既可以是已排序的字符串，也可以将字符映射成数字，并组成的字符串
            char[] s_arr = s.toCharArray();
            Arrays.sort(s_arr);
            String sort_s = Arrays.toString(s_arr);

            if (!map.containsKey(sort_s)) {
                map.put(sort_s, new ArrayList<>());
            }
            map.get(sort_s).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
