package com.company.valid_anagram;

import java.util.Arrays;

// 对比两个字符串是否 字母异位词

// 注意点
// 1 确认是否大小写敏感
public class First {
    // 排序比较法
    public boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 对字符串的字符进行排序
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        Arrays.sort(s_arr);
        Arrays.sort(t_arr);

        // 对比排序之后的字符串
        return Arrays.equals(s_arr, t_arr);
    }

    public boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        //利用数组保存 字符串s中每个字符出现的次数
        char[] arr = new char[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (char c : arr) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
