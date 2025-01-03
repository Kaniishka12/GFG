//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestPrefixSuffix(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int longestPrefixSuffix(String s) {
        // code here
        int n = s.length();
        int[] lps = new int[n]; // LPS array to store lengths of prefix which are also suffix
        int len = 0; // Length of the current longest prefix which is also a suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1]; // Try to find the previous longest prefix which is also suffix
                } else {
                    lps[i] = 0; // No match
                    i++;
                }
            }
        }

        int longestPrefixLength = lps[n - 1]; // Length of the longest happy prefix
        return longestPrefixLength;
    }
}