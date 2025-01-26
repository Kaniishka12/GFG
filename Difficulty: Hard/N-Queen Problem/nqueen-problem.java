//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];  // Array to represent the placement of queens
        solveNQueens(n, 0, board, result);
        return result;
    }

    // Backtracking function to find all valid solutions
    private void solveNQueens(int n, int row, int[] board, ArrayList<ArrayList<Integer>> result) {
        if (row == n) {
            // A solution is found, add the current board to the result
            ArrayList<Integer> currentSolution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                currentSolution.add(board[i] + 1);  // Adding 1 because the question expects 1-indexed rows
            }
            result.add(currentSolution);
            return;
        }

        for (int col = 0; col < n; col++) {
            // Check if it's safe to place the queen at (row, col)
            if (isSafe(board, row, col)) {
                board[row] = col;  // Place the queen at the current position
                solveNQueens(n, row + 1, board, result);  // Move to the next row
                board[row] = -1;  // Backtrack
            }
        }
    }

    // Function to check if placing the queen at (row, col) is safe
    private boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            // Check if the current column or diagonals are attacked by a previous queen
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    
    }
}