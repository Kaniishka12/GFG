//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t > 0) {
            String s = sc.nextLine();
            Solution ob = new Solution();
            if (ob.sentencePalindrome(s))
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {

    public boolean sentencePalindrome(String s) {
        // code here
        int left=0;
        int right=s.length()-1;
        while(left<right){
            char l=s.charAt(left);
            char r=s.charAt(right);
            if(!Character.isLetterOrDigit(l)){
                left++;
            }else if(!Character.isLetterOrDigit(r)){
                right--;
            }else if(Character.toLowerCase(l)!=Character.toLowerCase(r)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}