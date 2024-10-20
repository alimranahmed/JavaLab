package com.imranic.algorithms.backtracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        System.out.println(getPathsWithObstacles("", maze, 0, 0));
    }

    // --- This is NOT BackTracking, see MazeAll Direction for BackTracking---
    // This method get the all possible path from (0, 0) to (2, 2) when there is obstacle in the maze
    // So, once we reach the edge, we stop moving forward on that direction
    // As we only go diagonal. down and right, D means diagonal, V means Vertical/Down, H means Horizontal/Down
    // Example: 3x3 maze we need to go from s to e, x is the obstacle
    //    |  0  |  1  |  2  |
    // ----------------------
    // 0  |  s  |     |     |
    // ----------------------
    // 1  |     |  x  |     |
    // ----------------------
    // 2  |     |     |  e  |
    // ----------------------
    public static ArrayList<String> getPathsWithObstacles(String processed, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(processed);
            return path;
        }

        if (!maze[r][c]) { // The position that has obstacle
            return new ArrayList<>();
        }

        ArrayList<String> paths = new ArrayList<>();
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            ArrayList<String> diagonal = getPathsWithObstacles(processed+"D", maze, r + 1, c + 1);
            paths.addAll(diagonal);
        }

        if (r < maze.length - 1) {
            ArrayList<String> vertical = getPathsWithObstacles(processed+"V", maze, r + 1, c);
            paths.addAll(vertical);
        }
        if (c < maze[0].length - 1) {
            ArrayList<String> horizontal = getPathsWithObstacles(processed+"H", maze, r, c + 1);
            paths.addAll(horizontal);
        }
        return paths;
    }
}
