package com.imranic.leetcode;

// 7. Reverse Integer
// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        System.out.println(solution.reverse(-2147483648));
    }
    public int reverse(int x) {
        int reversed = 0;
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        while(x != 0) {
            int lastDigit = x % 10;
            if (reversed > (Integer.MAX_VALUE - lastDigit) / 10) {
                return 0;
            }
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }

        return reversed * sign;
    }
}
