package com.imranic.leetcode.grind75;

import java.util.Arrays;

// 733. Flood Fill
// https://leetcode.com/problems/flood-fill
public class FloodFill {
    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] filledImage = ff.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(filledImage));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        if (row < 0 || row > image.length - 1 || col < 0 || col > image[0].length - 1 || image[row][col] != originalColor) {
            return;
        }
        image[row][col] = newColor;
        dfs(image, row, col + 1, originalColor, newColor);
        dfs(image, row, col - 1, originalColor, newColor);
        dfs(image, row + 1, col, originalColor, newColor);
        dfs(image, row - 1, col, originalColor, newColor);
    }
}
