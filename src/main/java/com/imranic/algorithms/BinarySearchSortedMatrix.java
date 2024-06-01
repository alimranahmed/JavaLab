package com.imranic.algorithms;

import java.util.Arrays;

public class BinarySearchSortedMatrix {
    public static void main(String[] args) {
        // with every row or column increase the value also increase
        int[][] matrix = {
                {10, 11, 12, 13, 15, 16},
                {17, 19, 20, 25, 30, 35},
                {37, 38, 39, 50, 61, 72},
        };
        int[] output = (new BinarySearchSortedMatrix()).search(matrix, 39);
        System.out.println(Arrays.toString(output));
    }

    public int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // be cautious, matrix can be empty

        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols-1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;
        // run the loop till two rows are remaining
        while(rStart < (rEnd - 1)) {
            int mid = rStart + (rEnd - rStart) / 2;

            if (matrix[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }

            if (matrix[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        // Now we have two rows
        // check if target is in the col of two rows
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }

        if (matrix[rStart - 1][cMid] == target) {
            return new int[]{rStart - 1, cMid};
        }

        if (matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        // search in 1st half
        if (target <= matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }
        // search in 2nd half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols -1, target);
        }
        // search in 3nd half
        if (target >= matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, rStart + 1, 0, cMid -1, target);
        } else {
            // search in 4th half
            return binarySearch(matrix, rStart + 1, cMid + 1, cols -1, target);

        }
    }

    // Search in the row between the column provided
    public int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target) {
        while (colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }

            if (matrix[row][mid] < target) {
                colStart = mid + 1;
            } else {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
