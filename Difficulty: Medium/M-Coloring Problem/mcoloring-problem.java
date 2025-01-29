//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean graphColoring(int v, List<int[]> edges, int m) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        // Construct adjacency list
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[v]; // Color array initialized to 0

        return solve(0, graph, color, v, m);
    }

    private boolean solve(int node, List<List<Integer>> graph, int[] color, int n, int m) {
        if (node == n) return true; // All nodes successfully colored

        for (int col = 1; col <= m; col++) {
            if (isSafe(node, graph, color, col)) {
                color[node] = col; // Assign color
                if (solve(node + 1, graph, color, n, m)) return true; // Recur for next node
                color[node] = 0; // Backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int node, List<List<Integer>> graph, int[] color, int col) {
        for (int neighbor : graph.get(node)) {
            if (color[neighbor] == col) return false; // Adjacent node has the same color
        }
        return true;
    }

    
}