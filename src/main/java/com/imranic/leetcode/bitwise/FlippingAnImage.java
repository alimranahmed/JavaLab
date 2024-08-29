package com.imranic.leetcode.bitwise;

import java.util.Arrays;

// 832. Flipping an Image
// https://leetcode.com/problems/flipping-an-image
public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] newImage = (new FlippingAnImage()).flipAndInvertImage(image);
        for (int[] i : newImage) {
            System.out.println(Arrays.toString(i));
        }
    }

    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image) {
            for(int col = 0; col <= (row.length - 1) / 2; col++) {
                int temp = row[col] ^ 1;
                row[col] = row[row.length - 1 - col] ^ 1;
                row[row.length - 1 - col] = temp;
            }
        }

        return image;
    }
}
