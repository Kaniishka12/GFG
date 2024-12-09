//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {
       
    }

    static List<Integer> findPrimeFactors(int N) {
        // code here
          List<Integer> factors = new ArrayList<>();
        
        // Handle the factor 2 first to make the subsequent checks easier
        while (N % 2 == 0) {
            factors.add(2);
            N = N / 2;
        }
        
        // Check for all odd factors from 3 upwards
        for (int i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                factors.add(i);
                N = N / i;
            }
        }

        // If N is a prime number greater than 2, add it to the list
        if (N > 2) {
            factors.add(N);
        }

        return factors;
        
    }
}
