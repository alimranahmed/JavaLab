package com.imranic.practices.recursion;

public class DigitProd {
    public static void main(String[] args) {
        int product = productOfDigits(432);
        System.out.println(product);
    }

    static int productOfDigits(int n) {
        if (n % 10 == n) {
            return n;
        }
        return n % 10 * productOfDigits(n / 10);
    }
}
