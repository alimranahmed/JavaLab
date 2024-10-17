package com.imranic.practices.recursion;

public class CharRemover {
    public static void main(String[] args) {
        String removedString = removeChar("abbbcad", 'b');
        System.out.println(removedString);
    }

    public static String removeChar(String str, char charToRemove) {
        if (str.isEmpty()) {
            return "";
        }
        char firstChar = str.charAt(0);
        if (firstChar == charToRemove) {
            return removeChar(str.substring(1), charToRemove);
        }
        return firstChar + removeChar(str.substring(1), charToRemove);
    }
}
