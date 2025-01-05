//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int idx = obj.peakElement(a);
            int n = a.length;
            if (idx < 0 && idx >= n)
                System.out.println("false");
            else {
                if (n == 1 && idx == 0)
                    f = 1;
                else if (idx == 0 && a[0] > a[1])
                    f = 1;
                else if (idx == n - 1 && a[n - 1] > a[n - 2])
                    f = 1;
                else if (idx > 0 && idx < n && a[idx] > a[idx + 1] &&
                         a[idx] > a[idx - 1])
                    f = 1;
                else
                    f = 0;
                if (f == 1) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public int peakElement(int[] arr) {
      int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // Check if the mid is in the increasing part of the array
            if (arr[mid] < arr[mid + 1]) {
                // Move to the right
                left = mid + 1;
            } else {
                // Move to the left
                right = mid;
            }
        }

        // At the end of the binary search, left == right, which points to the peak index
        return right;
    }
}
