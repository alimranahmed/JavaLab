package com.imranic.algorithms;

public class FindingFactors {
    public static void main(String[] args) {
        factors1(20);
        System.out.println();
        factors2(20);
    }

    // O(n)
    public static void factors1(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void factors2(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (n / i != i) {
                    System.out.print((n / i) + " ");
                }
            }
        }
    }
}
