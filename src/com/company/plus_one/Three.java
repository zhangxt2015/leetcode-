package com.company.plus_one;

public class Three {
    // 数组末尾元素+1
    public int[] solution1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] new_digits = new int[digits.length + 1];
        new_digits[0] = 1;
        return new_digits;
    }
}
