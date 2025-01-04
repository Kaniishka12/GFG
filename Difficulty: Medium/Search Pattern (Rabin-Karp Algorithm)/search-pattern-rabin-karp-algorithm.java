//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
        ArrayList<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        
        // Loop through the text and check substrings of length m
        for (int i = 0; i <= n - m; i++) {
            // Extract substring of text from index i to i + m
            String currentSubstring = text.substring(i, i + m);
            
            // Check if the current substring matches the pattern
            if (currentSubstring.equals(pattern)) {
                occurrences.add(i + 1); // Add 1-based index
            }
        }
        
        return occurrences;
        
        
    }
}