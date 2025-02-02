//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter ot = new PrintWriter(System.out);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.printUniqueSubsets(nums);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            ot.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                ot.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    ot.print(ans.get(i).get(j) + " ");
                ot.print("]");
            }
            ot.println(" ]");
        }
        ot.close();
    }
}

// } Driver Code Ends

class Solution {
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates and ensure subsets are sorted
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempSet, int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates to avoid duplicate subsets
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the current number
            tempSet.add(nums[i]);

            // Recur with the next index
            backtrack(result, tempSet, nums, i + 1);

            // Exclude the current number (backtrack)
            tempSet.remove(tempSet.size() - 1);
        }
    }
}