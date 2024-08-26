package com.imranic.practices.bitwise;

public class OddEven {
    public static void main(String[] args) {
        int n = 70;
        System.out.println(n+" an odd number? "+ isOdd(n));
    }
    public static boolean isOdd(int num) {
        // As binary representation of a number is all power of 2
        // except the LSD is 2 to the power 0, which 1
        // So, if the number is odd then the last digit is 1 otherwise 0
        // Now if we make a binary AND operation with 1,
        // if the result is 1 that means the last digit is 1, so odd,
        // otherwise even
        return (num & 1) == 1;
    }
}
