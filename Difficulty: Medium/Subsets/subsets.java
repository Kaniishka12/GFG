//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Using a Set to remove duplicates
            Set<Integer> uniqueElements = new LinkedHashSet<>();
            for (String token : tokens) {
                uniqueElements.add(Integer.parseInt(token));
            }

            // Converting the set to an array
            int[] arr = new int[uniqueElements.size()];
            int idx = 0;
            for (int num : uniqueElements) {
                arr[idx++] = num;
            }

            // Finding and printing subsets
            ArrayList<ArrayList<Integer>> res = new Solution().subsets(arr);
            for (ArrayList<Integer> subset : res) {
                if (subset.size() == 0) {
                    System.out.println("[]");
                } else {
                    for (int num : subset) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // Ensure lexicographical order
        generateSubsets(arr, 0, new ArrayList<>(), result);
        return result;
        
    }
     private static void generateSubsets(int[] arr, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add current subset to result
        
        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]); // Include current element
            generateSubsets(arr, i + 1, current, result); // Recur for next elements
            current.remove(current.size() - 1); // Backtrack
        }
    }
}