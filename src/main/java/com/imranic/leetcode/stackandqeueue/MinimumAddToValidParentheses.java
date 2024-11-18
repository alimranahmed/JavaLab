package com.imranic.leetcode.stackandqeueue;

import java.util.Stack;

// 921. Minimum Add to Make Parentheses Valid
// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class MinimumAddToValidParentheses {
    public static void main(String[] args) {
        int min = new MinimumAddToValidParentheses()
                .minAddToMakeValid("())");
        System.out.println(min);
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    min++;
                }
            }
        }
        min += stack.size();
        return min;
    }
}
