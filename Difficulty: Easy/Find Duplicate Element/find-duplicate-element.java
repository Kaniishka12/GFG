//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            // long n = Long.parseLong(br.readLine().trim());
            int arr[] = new int[10];

            String line = read.readLine(); // to read multiple integers line
            String[] strs = line.trim().split("\\s+");

            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.findDuplicate(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public int findDuplicate(int arr[]) {
        // Your code goes here
        Set<Integer> ans = new HashSet<>();
        for(int i = 0 ; i<arr.length;i++){
            if(ans.contains(arr[i])){
                return arr[i];
            }
            
            else{
                ans.add(arr[i]);
            }
        }
        return -1;
    }
}