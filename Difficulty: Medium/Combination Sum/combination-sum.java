//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    
out.println("~");
}
	    out.flush();
    }
    
}
// } Driver Code Ends


class Solution {
    // Function to return a list of indexes denoting the required combinations whose sum is equal to B.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        // Removing duplicates and sorting the array to meet the constraints
        Set<Integer> uniqueSet = new HashSet<>(A);
        ArrayList<Integer> arr = new ArrayList<>(uniqueSet);
        Collections.sort(arr);
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findCombinations(0, arr, B, new ArrayList<>(), result);
        return result;
    }

    private static void findCombinations(int index, ArrayList<Integer> arr, int target,
                                         ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        // Base condition: if the target becomes zero, add the combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through the array starting from the current index
        for (int i = index; i < arr.size(); i++) {
            if (arr.get(i) > target) {
                break; // Stop further exploration as the array is sorted
            }

            // Add the current element to the combination
            current.add(arr.get(i));
            // Recurse with the same index (to allow the same element to be used again)
            findCombinations(i, arr, target - arr.get(i), current, result);
            // Backtrack: remove the last added element to explore other combinations
            current.remove(current.size() - 1);
        }
    }}