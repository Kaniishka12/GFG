//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> deque = new ArrayList<>(); // Simulates a deque to store indices

        for (int i = 0; i < arr.length; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.get(0) < i - k + 1) {
                deque.remove(0);
            }

            // Remove indices of elements smaller than the current element
            // from the back of the deque
            while (!deque.isEmpty() && arr[deque.get(deque.size() - 1)] < arr[i]) {
                deque.remove(deque.size() - 1);
            }

            // Add the current element's index to the deque
            deque.add(i);

            // Add the maximum element of the current window to the result
            if (i >= k - 1) {
                result.add(arr[deque.get(0)]);
            }
        }

        return result;
        
    }
}