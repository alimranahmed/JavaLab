package com.imranic.leetcode.grind75;

// 67. Add Binary
// https://leetcode.com/problems/add-binary
public class AddBinary {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();

        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sum = new StringBuilder();
        while(i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sum.append(carry % 2);
            carry = carry / 2;
        }

        return sum.reverse().toString();
    }
}
