package com.imranic.algorithms;

public class SqrtUsingBinarySearch {

    public static void main(String[] args) {
        int number = 40;
        int precision = 3;
        double sqrt = (new SqrtUsingBinarySearch())
                .squareRoot(number, precision);

        System.out.println("Square root of " + number + " is " + sqrt);
    }

    public double squareRoot(int number, int precision) {

        int start = 0;
        int end = number;
        double root = 0.0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid * mid == number) {
                return mid;
            }

            if (mid * mid > number) {
                end = mid - 1;
                root = end;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(root);

        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while ( root * root <= number) {
                root += increment;
            }
            root -= increment;
            increment /= 10;
        }

        return root;
    }
}
