//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> result = new ArrayList<>();
        int n = mat.size();
        if (mat.get(0).get(0) == 0 || mat.get(n - 1).get(n - 1) == 0) {
            return result; // No path if start or end is blocked
        }

        // Initialize visited matrix
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        // Start backtracking
        backtrack(mat, visited, 0, 0, "", result);

        // Sort the result lexicographically
        Collections.sort(result);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> mat, boolean[][] visited, int row, int col, String path, ArrayList<String> result) {
        int n = mat.size();

        // If destination is reached, add the path to the result
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        // Explore all four directions in lexicographical order: D, L, R, U
        // Down
        if (row + 1 < n && mat.get(row + 1).get(col) == 1 && !visited[row + 1][col]) {
            visited[row + 1][col] = true;
            backtrack(mat, visited, row + 1, col, path + "D", result);
            visited[row + 1][col] = false; // Backtrack
        }

        // Left
        if (col - 1 >= 0 && mat.get(row).get(col - 1) == 1 && !visited[row][col - 1]) {
            visited[row][col - 1] = true;
            backtrack(mat, visited, row, col - 1, path + "L", result);
            visited[row][col - 1] = false; // Backtrack
        }

        // Right
        if (col + 1 < n && mat.get(row).get(col + 1) == 1 && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            backtrack(mat, visited, row, col + 1, path + "R", result);
            visited[row][col + 1] = false; // Backtrack
        }

        // Up
        if (row - 1 >= 0 && mat.get(row - 1).get(col) == 1 && !visited[row - 1][col]) {
            visited[row - 1][col] = true;
            backtrack(mat, visited, row - 1, col, path + "U", result);
            visited[row - 1][col] = false; // Backtrack
        }
    }
}