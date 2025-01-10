//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution {
     static boolean isPossible(int[] arr, int N, int K, int maxSum) {
        int subarrays = 1; // Start with one subarray
        int currentSum = 0;

        for (int num : arr) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                subarrays++;
                currentSum = num;
                if (subarrays > K) return false; // More subarrays needed than allowed
            }
        }
        return true;
    }
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int maxElement = 0;
        int sumOfArray = 0;

        // Find the largest element and sum of the array
        for (int num : arr) {
            maxElement = Math.max(maxElement, num);
            sumOfArray += num;
        }

        int low = maxElement, high = sumOfArray;
        int result = high;

        // Binary search to find the minimized largest subarray sum
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, N, K, mid)) {
                result = mid; // Update result
                high = mid - 1; // Try for a smaller maximum sum
            } else {
                low = mid + 1; // Increase the allowed maximum sum
            }
        }
        return result;
    }
};