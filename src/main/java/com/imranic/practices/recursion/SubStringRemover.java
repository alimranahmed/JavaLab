package com.imranic.practices.recursion;

public class SubStringRemover {
    public static void main(String[] args) {
        String removedString = removeStr("Hello world", "ll");
        System.out.println(removedString);
    }

    public static String removeStr(String str, String strToRemove) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith(strToRemove)) {
            return removeStr(str.substring(strToRemove.length()), strToRemove);
        }
        return str.charAt(0) + removeStr(str.substring(1), strToRemove);
    }
}
