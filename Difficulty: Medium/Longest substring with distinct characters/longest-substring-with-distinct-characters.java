//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n=s.length();
        int ml=0;
        int l=0;
        int r=0;
        HashSet<Character> sett=new HashSet<>();
        while(r<n){
            if(!sett.contains(s.charAt(r))){
                sett.add(s.charAt(r));
                ml=Math.max(ml,r-l+1);
                r++;
                
            }else{
                sett.remove(s.charAt(l));
                l++;
                
            }
        }
        return ml;
    }
}