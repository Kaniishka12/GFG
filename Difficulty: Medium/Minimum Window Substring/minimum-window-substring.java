//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            if (ans.length() == 0) {
                System.out.println("\"\"");
            } else {
                System.out.println(ans);
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String minWindow(String s1, String s2) {
        // code here
   int m = s1.length(), n = s2.length();
        if (m < n) return "";

        // DP array to track the end of substrings
        int[][] dp = new int[m][n];
        
        // Fill DP for matching the first character of s2
        dp[0][0] = (s1.charAt(0) == s2.charAt(0)) ? 0 : -1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (s1.charAt(i) == s2.charAt(0)) ? i : dp[i - 1][0];
        }

        // Fill the rest of the DP table
        for (int j = 1; j < n; j++) {
            dp[0][j] = -1; // Not possible to match more characters with just 1 char
            for (int i = 1; i < m; i++) {
                dp[i][j] = (s1.charAt(i) == s2.charAt(j)) ? dp[i - 1][j - 1] : dp[i - 1][j];
            }
        }

        // Find the minimum window
        int start = -1, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dp[i][n - 1] != -1) {
                int length = i - dp[i][n - 1] + 1;
                if (length < minLen) {
                    minLen = length;
                    start = dp[i][n - 1];
                }
            }
        }

        return (start == -1) ? "" : s1.substring(start, start + minLen);
    }
}
