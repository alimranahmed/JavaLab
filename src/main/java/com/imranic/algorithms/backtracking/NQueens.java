package com.imranic.algorithms.backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int count = queens(board, 0);
        System.out.println("There "+count+" ways to do it");
    }
    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            return 1;
        }

        int count = 0;
        // placing the queen and checking every row and col
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if(board[i][col]) {
                return false;
            }
        }

        // diagonal up-left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // diagonal up-right
        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 0; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row: board) {
            for (boolean hasQueen: row) {
                if (hasQueen) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
