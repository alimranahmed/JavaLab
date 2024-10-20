package com.imranic.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeAllDirection {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        //System.out.println(getPaths("", maze, 0, 0));

        int[][] path = new int[maze.length][maze[0].length];
        printPaths("", maze, 0, 0, path, 1);
    }
    // =========BackTracking=======
    // This method get the all possible path from (0, 0) to (2, 2)
    // Once we reach the edge, we stop moving forward on that direction
    // We go all four direction, Left, Right, Up, Down(L, R, U, D)
    // As, we go all four direction it can try to visit same cell multiple time
    // to solve this problem, we can mark that cell as visited(false),
    // so, we can keep track to avoid those cells
    // BUT the problem with this marking as "false" is:
    // when we try to visit that cell via a different path
    // that cell still contain false, so we cannot visit that path as it's marked as visited!
    // We need to mark the path as visited for one path,
    // then revert back to true(not visited) once that path is explored.
    // Basically, we need to revert back the original value once the recursive function call is returned
    // We are setting/tracking back the previous values
    // We are trying to get back the state of the maze before taking a path...
    // What my array/maze would look like if I didn't take this path?
    // This is called BackTracking.
    // Example: 3x3 maze we need to go from s to e
    //    |  0  |  1  |  2  |
    // ----------------------
    // 0  |  s  |     |     |
    // ----------------------
    // 1  |     |     |     |
    // ----------------------
    // 2  |     |     |  e  |
    // ----------------------
    public static ArrayList<String> getPaths(String processed, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(processed);
            return path;
        }

        if (!maze[r][c]) {
            return new ArrayList<>();
        }

        // We are vising this cell, so marking it as false(visited)
        maze[r][c] = false;

        ArrayList<String> paths = new ArrayList<>();

        if (r < maze.length - 1) {
            ArrayList<String> down = getPaths(processed+"D", maze, r + 1, c);
            paths.addAll(down);
        }

        if (r > 0) {
            ArrayList<String> up = getPaths(processed+"U", maze, r - 1, c);
            paths.addAll(up);
        }
        if (c < maze[0].length - 1) {
            ArrayList<String> right = getPaths(processed+"R", maze, r, c + 1);
            paths.addAll(right);
        }
        if (c > 0) {
            ArrayList<String> left = getPaths(processed+"L", maze, r, c - 1);
            paths.addAll(left);
        }
        // We are returning the path here,
        // so reverting back cell's original value to true(not visited)
        maze[r][c] = true;
        return paths;
    }

    // This method does the same as getPaths() but it prints the paths as an array
    // Every cell traversed is denoted as step, 1 -> 2 -> 3 -> 4...
    public static void printPaths(String processed, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr: path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // We are vising this cell, so marking it as false(visited)
        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length - 1) {
            printPaths(processed+"D", maze, r + 1, c, path, step + 1);
        }

        if (r > 0) {
            printPaths(processed+"U", maze, r - 1, c, path, step + 1);
        }
        if (c < maze[0].length - 1) {
            printPaths(processed+"R", maze, r, c + 1, path, step + 1);
        }
        if (c > 0) {
            printPaths(processed+"L", maze, r, c - 1, path, step + 1);
        }
        // We are returning the path here,
        // so reverting back cell's original value to true(not visited)
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
