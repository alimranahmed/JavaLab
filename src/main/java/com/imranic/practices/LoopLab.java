package com.imranic.practices;

public class LoopLab implements Lab{
    @Override
    public void experiment() {
        for (int i = 1; i < 10; i++) {
            System.out.print(i + '\t');
        }
        System.out.println();
    }
}
