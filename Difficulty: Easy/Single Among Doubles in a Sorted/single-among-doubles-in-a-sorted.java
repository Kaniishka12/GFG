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
            int A = obj.findOnce(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findOnce(int[] arr) {
        // Complete this function
        int n = arr.length;
if (n == 1) {
    return arr[0];
}
if (arr[0] != arr[1]) {
    return arr[0];
}
if (arr[n - 1] != arr[n - 2]) {
    return arr[n - 1];
}
int low = 1;
int high = n - 2;
while (low <= high) {
    int mid = (low + high) / 2;
    if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
        return arr[mid];
    } else if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
        low = mid + 1;
    } else {
        high = mid - 1;
    }
}
return -1;

    }
}