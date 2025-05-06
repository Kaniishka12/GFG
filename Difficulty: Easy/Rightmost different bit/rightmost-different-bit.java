//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.BigInteger;
import java.util.*;

class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);

        // input number of testcases
        int t = sc.nextInt();
        int m, n;
        while (t-- > 0) {
            Solution obj = new Solution();
            // input m and n
            m = sc.nextInt();
            n = sc.nextInt();
            System.out.println(obj.posOfRightMostDiffBit(m, n));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n) {

        // Your code here
        if(m==n){
            return -1;
        }
        int count=0;
        int i=0;
        int x=m^n;
       while((x&(1<<i))==0){
           i++;
       }
       return i+1;
        
        
        
        
        
        
        
        
        
    }
}
