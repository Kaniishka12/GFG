//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t > 0) {
            String A = sc.nextLine();
            String B = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.repeatedStringMatch(A, B));
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int repeatedStringMatch(String a, String b) {
        // Your code goes here
         StringBuilder sb = new StringBuilder(a);
        int count = 1;  // Start with one repetition of a
        
        // Repeat a until the length of the repeated string is at least as long as b
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        
        // Check if b is a substring of the repeated string
        if (sb.toString().contains(b)) {
            return count;
        }
        
        // Append one more time to handle cases where b spans across repetitions
        sb.append(a);
        count++;
        if (sb.toString().contains(b)) {
            return count;
        }
return -1;
    }
}
