//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int arr[]) {
        // code here
         // Array to store all left multiplication
     // Array to store all left multiplication
    long[] left = new long[arr.length];

    // Array to store all right multiplication
    long[] right = new long[arr.length];

    left[0] = 1; // Initialize left[0] to 1
    for (int i = 1; i < arr.length; i++) {
      left[i] = left[i - 1] * arr[i - 1];
    }

    right[arr.length - 1] = 1; // Initialize right[last] to 1
    for (int i = arr.length - 2; i >= 0; i--) {
      right[i] = right[i + 1] * arr[i + 1];
    }

    long[] ans = new long[arr.length];
    for (int i = 0; i < arr.length; i++) {
      ans[i] = left[i] * right[i]; // Multiply left and right arrays
    }

    return ans;
    }
}
