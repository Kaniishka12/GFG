//{ Driver Code Starts
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine(); // Use lowercase 's'

            Solution ob = new Solution();
            if (ob.isPalindrome(s)) // Check palindrome
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isPalindrome(String s) {
        // code here
        int left=0;
        int right=s.length()-1;
        while(left<right)
        {
            char l=s.charAt(left),r=s.charAt(right);
            if(!Character.isLetterOrDigit(l))
            {
                left++;
            }
            else if(!Character.isLetterOrDigit(r))
            {
                right--;
            }
            else if(Character.toLowerCase(l)!=Character.toLowerCase(r))
            {
                return false;
            }
            else{
                left++;
                right--;
            }
           

        }
         return true;
    }
};