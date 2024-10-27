package com.imranic.leetcode.backtracking;


// 37. Sudoku Solver
// https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver2 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        (new SudokuSolver2()).solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        solveUsingBackTracking(board, 0, 0);
        display(board);
    }

    private boolean solveUsingBackTracking(char[][] board, int row, int col) {
        for (int i = row; i < board.length; i++) {
            for (int j = col; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (int number = 1; number <= 9; number++) {
                        if (isSafe(board, i, j, (char) (number + '0'))) {
                            board[i][j] = (char) (number + '0');
                            if (solveUsingBackTracking(board, i, j + 1)) {
                                return true;
                            } else {
                                // back track
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
            col = 0;
        }
        return true;
    }

    private void display(char[][] board) {
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(chars[j]+" ");
            }
            System.out.println();
        }
    }

    private boolean isSafe(char[][] board, int row, int col, char n) {
        // Check row and col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == n || board[row][i] == n) {
                return false;
            }
        }

        // Check internal 3x3 grid, 3 is square root of 9(length)
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - (row % sqrt);
        int colStart = col - (col % sqrt);
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }
}
