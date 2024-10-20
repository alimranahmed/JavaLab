package com.imranic.algorithms.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(countPath(3, 3));
        System.out.println(getPaths("", 3, 3));
    }

    // --- This is NOT BackTracking, see MazeAll Direction for BackTracking---
    // This method count the number of available paths
    // from first row, first col e.g. (3, 3) to last row, last col(1, 1)
    // We can only go down and right
    // Example: 3x3 maze we need to go from s to e
    //    |  3  |  2  |  1  |
    // ----------------------
    // 3  |  s  |     |     |
    // ----------------------
    // 2  |     |     |     |
    // ----------------------
    // 1  |     |     |  e  |
    // ----------------------
    // If we reach the edge of row or column we will only have one path to reach the end.
    static int countPath(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = countPath(r - 1, c);
        int right = countPath(r, c - 1);
        return left + right;
    }

    // --- This is NOT BackTracking, see MazeAll Direction for BackTracking---
    // This method get the all possible path from (3, 3) to (1, 1)
    // So, once we reach the edge of the maze then we check if col or row = 1
    // If either of them is 1, then we don't make the call decreasing that row or col
    // As we only go diagonal, down and right, D means diagonal, V means Vertical/Down, H means Horizontal/Down
    // Example: 3x3 maze we need to go from s to e
    //    |  3  |  2  |  1  |
    // ----------------------
    // 3  |  s  |     |     |
    // ----------------------
    // 2  |     |     |     |
    // ----------------------
    // 1  |     |     |  e  |
    // ----------------------
    static ArrayList<String> getPaths(String processed, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(processed);
            return path;
        }

        ArrayList<String> paths = new ArrayList<>();
        if (r > 1 && c > 1) {
            ArrayList<String> left = getPaths(processed+"D", r - 1, c - 1);
            paths.addAll(left);
        }

        if (r > 1) {
            ArrayList<String> left = getPaths(processed+"V", r - 1, c);
            paths.addAll(left);
        }
        if (c > 1) {
            ArrayList<String> right = getPaths(processed+"H", r, c - 1);
            paths.addAll(right);
        }
        return paths;
    }
}
