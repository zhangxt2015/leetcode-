package com.company.valid_anagram;

import java.util.Arrays;

public class Second {
    // 比较两个字符串是否是 字母异位词
    // 字符串转化为数组，比较排序之后的数组是否相等
    public boolean solution1(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        Arrays.sort(s_arr);
        Arrays.sort(t_arr);

        return Arrays.equals(s_arr, t_arr);
    }

    // 将每一个字符映射为1-26的数字，保存到数组计数统计
    public boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();

        int[] arr = new int[26];
        for (int i = 0; i < s_arr.length; i++) {
            arr[s_arr[i] - 'a']++;
            arr[t_arr[i] - 'a']--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
