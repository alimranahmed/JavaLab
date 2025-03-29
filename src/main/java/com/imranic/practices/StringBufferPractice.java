package com.imranic.practices;

import java.text.DecimalFormat;

public class StringBufferPractice {
    public static void main(String[] args) {
        // StringBugger and StringBuilder is mutable and String is immutable
        // StringBuffer is thread safe, so slower
        // String Builder is not thread safe, so faster
        StringBuffer sb = new StringBuffer("Something");
        System.out.println(sb.reverse());

        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(7.29));
    }
}
