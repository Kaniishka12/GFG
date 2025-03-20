//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int k = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int[] arr = new int[n];
            
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            int[] ptr = ob.kthLargest(k,arr,n);
            for(int i=0; i<n; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
          PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            minHeap.offer(arr[i]); // Add the new element

            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest element to keep size k
            }

            result[i] = (minHeap.size() < k) ? -1 : minHeap.peek();
        }

        return result;
    }
};