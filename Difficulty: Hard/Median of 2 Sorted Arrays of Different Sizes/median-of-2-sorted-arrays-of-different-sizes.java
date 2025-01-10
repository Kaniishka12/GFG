//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String arr1[] = br.readLine().split(" ");
            int[] a = new int[arr1.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);

            String arr2[] = br.readLine().split(" ");
            int[] b = new int[arr2.length];

            for (int i = 0; i < arr2.length; i++) b[i] = Integer.parseInt(arr2[i]);

            if (b.length == 1 && b[0] == 0) {
                b = new int[0];
            }
            double res = new Solution().medianOf2(a, b);

            if (res == (int)res)
                System.out.println((int)res);
            else
                System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public double medianOf2(int a[], int b[]) {
      int n1 = a.length, n2 = b.length;

    // Ensure the first array is the smaller one.
    if (n1 > n2) {
        int[] temp = a;
        a = b;
        b = temp;
        n1 = a.length;
        n2 = b.length;
    }

    int n = n1 + n2; // Total length of combined arrays
    int left = (n + 1) / 2; // Size of the left partition

    int low = 0, high = n1;

    // Binary search to find the correct partition.
    while (low <= high) {
        int mid1 = (low + high) / 2;
        int mid2 = left - mid1;

        // Values on either side of the partition.
        int l1;
        if (mid1 > 0) {
            l1 = a[mid1 - 1];
        } else {
            l1 = Integer.MIN_VALUE;
        }

        int l2;
        if (mid2 > 0) {
            l2 = b[mid2 - 1];
        } else {
            l2 = Integer.MIN_VALUE;
        }

        int r1;
        if (mid1 < n1) {
            r1 = a[mid1];
        } else {
            r1 = Integer.MAX_VALUE;
        }

        int r2;
        if (mid2 < n2) {
            r2 = b[mid2];
        } else {
            r2 = Integer.MAX_VALUE;
        }

        if (l1 <= r2 && l2 <= r1) {
            if (n % 2 == 1) {
                return Math.max(l1, l2);
            } else {
                return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
        } else if (l1 > r2) {
            high = mid1 - 1;
        } else {
            low = mid1 + 1;
        }
    }

    return 0.0;
    }
    
}