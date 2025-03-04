//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int top = 0, down = n - 1;

        // Step 1: Narrow down the potential celebrity
        while (top < down) {
            if (mat[top][down] == 1) {
                // top knows down → top is not a celebrity
                top++;
            } else {
                // down is not a celebrity
                down--;
            }
        }

        int candidate = top; // After loop, top == down, this is our candidate

        // Step 2: Verify if candidate is a real celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1; // Candidate knows someone OR not everyone knows candidate
                }
            }
        }

        return candidate;
    }
}