//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Remove elements from stack while they are smaller than arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            
            // If stack is empty, span = i + 1 (all previous elements are smaller)
            if (stack.isEmpty()) {
                span.add(i + 1);
            } else {
                span.add(i - stack.peek());
            }
            
            // Push current index onto the stack
            stack.push(i);
        }
        
        return span;
    }
}