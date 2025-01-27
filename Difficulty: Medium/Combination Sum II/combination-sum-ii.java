//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr); // Sort the array to handle duplicates and allow lexicographical order
        findCombinations(0, arr, n, k, ans, new ArrayList<>());
        return ans;
    }

    private void findCombinations(int ind, int[] arr, int n, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) { // Base case: if the target is met, add the current combination
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < n; i++) {
            // Skip duplicates in the same recursive level
            if (i > ind && arr[i] == arr[i - 1]) continue;

            // If the current element exceeds the target, no need to proceed further
            if (arr[i] > target) break;

            // Include the current element
            ds.add(arr[i]);
            // Recurse with the next index (i + 1) to ensure each element is used at most once
            findCombinations(i + 1, arr, n, target - arr[i], ans, ds);
            // Backtrack by removing the last added element
            ds.remove(ds.size() - 1);
        }
    }

}