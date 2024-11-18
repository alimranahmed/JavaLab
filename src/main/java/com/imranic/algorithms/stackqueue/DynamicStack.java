package com.imranic.algorithms.stackqueue;


// This one doesn't have any size limit
public class DynamicStack extends CustomStack{

    public boolean push(int item) throws Exception {
        if (isFull()) {
            int[] temp = new int[data.length * 2];
            System.arraycopy(data, 0, temp, 0, data.length);
            this.data = temp;
        }
        return super.push(item);
    }
}
