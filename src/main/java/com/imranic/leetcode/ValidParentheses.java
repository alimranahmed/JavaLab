package com.imranic.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses
public class ValidParentheses {
    public static void run() {

        String case1 = "(){}[()]";
        boolean isValid = (new ValidParentheses()).isValid(case1);
        System.out.println(case1+" is a valid expression: "+isValid);

        String case2 = "]";
        isValid = (new ValidParentheses()).isValid(case2);
        System.out.println(case2+" is a valid expression: "+isValid);

        String case3 = "[";
        isValid = (new ValidParentheses()).isValid(case3);
        System.out.println(case3+" is a valid expression: "+isValid);
    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            }else if (stack.isEmpty() || stack.pop() != map.get(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
