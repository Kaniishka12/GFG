//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Initialize variables
        String ans = "";
        ArrayList<String> result = new ArrayList<>();
         
        
        // Start the recursive process
        findPermutation(s, ans, result);
        
        // Return the final result
         return new ArrayList<>(new HashSet<>(result));
    }
    
    private void findPermutation(String s, String ans, ArrayList<String> result) {
        // Base case: If the string is empty, add the current permutation to the result
       if (s.length() == 0) {
            result.add(ans);
            return;
           
        }
      
        // Iterate through each character of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Current character
            String ne = s.substring(0, i) + s.substring(i + 1); // Remaining string
            findPermutation(ne, ans + c, result); // Recursive call with updated parameters
        }
    }
}