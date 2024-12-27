//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countRevPairs(int N, int[] arr) {
        return mergeSortAndCount(arr, 0, N - 1);
    }

    private int mergeSortAndCount(int[] arr, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = (low + high) / 2;
        int count = mergeSortAndCount(arr, low, mid);
        count += mergeSortAndCount(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    private int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }

        return count;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}