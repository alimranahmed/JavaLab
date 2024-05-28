package com.imranic;

import com.imranic.algorithms.BinarySearch;
import com.imranic.algorithms.LinearSearch;
import com.imranic.algorithms.OrderAgnosticBinarySearch;

public class Main {
    public static void main(String[] args) {
        runPractices();
        leetCodeSolutions();
        runAlgorithms();
    }

    public static void runPractices() {
        //(new DateLab()).experiment();
        //(new LoopLab()).experiment();
    }

    public static void runAlgorithms() {
        //LinearSearch.run();
        //BinarySearch.run();
        OrderAgnosticBinarySearch.run();
    }

    public static void leetCodeSolutions() {
        //ValidParentheses.run();
        //FindEvenDigitNumber.run();
        //MaximumWealth.run();
    }
}