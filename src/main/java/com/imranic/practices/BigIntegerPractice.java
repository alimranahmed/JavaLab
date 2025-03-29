package com.imranic.practices;

import java.math.BigInteger;

public class BigIntegerPractice {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        BigInteger bigInteger = BigInteger.valueOf(Integer.MAX_VALUE).add(BigInteger.valueOf(Integer.MAX_VALUE));
        System.out.println(bigInteger);

        BigInteger bigStringInteger = new BigInteger("21474836471234567891011");
        System.out.println(bigStringInteger);
    }
}
