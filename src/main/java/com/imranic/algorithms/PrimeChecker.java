package com.imranic.algorithms;

public class PrimeChecker {
    public static void main(String[] args) {
        int n = 40;
        for (int i = 1; i <= n; i++) {
            System.out.println(i+" is Prime? "+(new PrimeChecker()).isPrime(i));
        }
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        int counter = 2;
        while(counter * counter <= number) {
            if (number % counter == 0) {
                return false;
            }
            counter++;
        }
        return true;
    }
}
