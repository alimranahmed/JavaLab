package com.imranic.algorithms.searching;

import java.util.Arrays;

public class BinarySearchRowColSortedMatrix {
    public static void main(String[] args) {
        // This matrix is sorted by row and colum
        // more down(row++) you go value increases
        // more right(col++) you go value increases
        int[][] matrix = {
                {10, 20, 50, 60, 70, 80, 95},
                {12, 24, 55, 61, 76, 82, 95},
                {14, 26, 57, 62, 78, 85, 95},
                {16, 28, 59, 64, 80, 86, 95},
        };

        int target = 78;
        int[] foundBlock = (new BinarySearchRowColSortedMatrix()).search(matrix, target);
        System.out.println(Arrays.toString(foundBlock));
    }

    public int[] search(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[r].length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r, c};
            }
            if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return new int[]{-1, -1};
    }
}
