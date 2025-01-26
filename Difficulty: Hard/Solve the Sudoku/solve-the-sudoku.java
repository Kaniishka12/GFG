//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver_class {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int grid[][] = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) grid[i][j] = sc.nextInt();
            }

            Solution ob = new Solution();

            if (ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("No solution exists");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][]) {
        int row = -1;
        int col = -1;
        boolean isEmpty = false;
        
        // Find an empty cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = true;
                    break;
                }
            }
            if (isEmpty) {
                break;
            }
        }
        
        // If no empty cell found, puzzle is solved
        if (!isEmpty) {
            return true;
        }
        
        // Try digits 1-9
        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;
                
                if (SolveSudoku(grid)) {
                    return true;
                }
                
                // If placing number didn't lead to a solution, backtrack
                grid[row][col] = 0;
            }
        }
        return false;
    }
    
    // Function to check if it's safe to place a number
    static boolean isSafe(int[][] grid, int row, int col, int num) {
        // Check row
        for (int j = 0; j < 9; j++) {
            if (grid[row][j] == num) {
                return false;
            }
        }
        
        // Check column
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }
        
        // Check 3x3 box
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }

    // Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}