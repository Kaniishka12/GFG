//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isPossible(int[] arr, int n, int k, int maxTime) {
        int painters = 1; // Start with one painter
        int currentSum = 0;

        for (int length : arr) {
            if (currentSum + length <= maxTime) {
                currentSum += length;
            } else {
                painters++;
                currentSum = length;
                if (painters > k) return false; // More painters needed than available
            }
        }
        return true;
    }
       

    public int minTime(int[] arr, int k) {
        int n = arr.length;
        int maxBoardLength = 0;
        int sumOfLengths = 0;

        // Find max board length and sum of all board lengths
        for (int length : arr) {
            maxBoardLength = Math.max(maxBoardLength, length);
            sumOfLengths += length;
        }

        int low = maxBoardLength, high = sumOfLengths;
        int result = high;

        // Binary search for the optimal minimum time
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, n, k, mid)) {
                result = mid; // Update result
                high = mid - 1; // Try for a smaller time
            } else {
                low = mid + 1; // Increase the allowed time
            }
        }
        return result;
    }
}
