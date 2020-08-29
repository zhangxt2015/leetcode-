package com.company.plus_one;

// 对数组组成的整数加一并返回和对应的数组
public class First {
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public int[] solution1(int[] digits) {
        //循环终止的条件，
        //  1 指定位置的数字小于9
        //  2 循环结束
        //循环继续的情况
        //  1 初始加一
        //  2 低位数字的进位
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                //当前位置小于9时，加一之后直接返回
                digits[i]++;
                return digits;
            }
            //等于9时，置零。
            digits[i] = 0;
        }

        int[] new_digits = new int[digits.length+1];
        new_digits[0] = 1;
        return new_digits;
    }
}
