package com.company.group_anagram;

import java.util.*;

// 对多个字母异位词进行分组
public class First {
    // 1 按照字母排序字母异位词
    // 2 使用hash写入对应的数组
    public List<List<String>> solution1(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] str_arr = str.toCharArray();
            Arrays.sort(str_arr);
            String sorted_str = String.valueOf(str_arr);
            if (!map.containsKey(sorted_str)) {
                map.put(sorted_str, new ArrayList());
            }
            map.get(sorted_str).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // 用一个数组表示一个字符串中每一个字符出现的次数
    public List<List<String>> solution2(String[] strs) {
        if (strs == null || strs.length < 1) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        int[] arr = new int[26];
        for (String s : strs) {
            Arrays.fill(arr, 0);
            char[] s_arr = s.toCharArray();
            for (char c : s_arr) arr[c - 'a']++;
            String sb_str = Arrays.toString(arr);
            if (!map.containsKey(sb_str)) map.put(sb_str, new ArrayList());
            map.get(sb_str).add(s);
        }
        return new ArrayList(map.values());
    }
}
