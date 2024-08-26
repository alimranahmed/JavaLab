package com.imranic.practices.bitwise;

public class FindUniqueNumber {
    // Question:
    // An array of integer that has only one unique element,
    // all other elements present twice
    // Find the unique element
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(getUnique(arr));
    }

    public static int getUnique(int[] arr) {
        // Explanation:
        // xor with same number results 0 as it cancelled out each other
        // so all the duplicate element cancelled out
        // only number left is the unique number
        // Note: all bitwise operations follow associative property, for example:
        // a & b & c & d = (a & b) & c & d = a & (b & c) & d
        int unique = 0;
        for( int n: arr) {
            unique ^= n;
        }
        return unique;
    }
}
