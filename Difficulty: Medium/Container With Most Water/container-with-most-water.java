//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxArea(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int maxArea(int arr[]) {
        // Code Here
        int l=0;
        int r=arr.length-1;
        int maxa=0;
        while(l<r){
            int lm=arr[l];
            int rm=arr[r];
            int minH=Math.min(lm,rm);
            maxa=Math.max(maxa,minH*(r-l));
            if(lm<rm){
                l++;
            }else{
                r--;
            }
        }
        return maxa;
    }
}