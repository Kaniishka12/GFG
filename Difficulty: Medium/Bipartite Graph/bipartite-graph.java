//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends




class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Create adjacency list for the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Fill the adjacency list
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // Since it's an undirected graph
        }

        // Array to store the colors of the nodes
        int[] colors = new int[V];
        Arrays.fill(colors, -1); // -1 means uncolored

        // Perform BFS for each uncolored vertex
        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) { // Not colored yet, start a BFS from this node
                if (!bfs(i, graph, colors)) {
                    return false; // If any component is not bipartite
                }
            }
        }

        return true; // All components are bipartite
    }

    // Helper BFS function to check if the component is bipartite
    private boolean bfs(int start, ArrayList<ArrayList<Integer>> graph, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0; // Start coloring with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Check all adjacent nodes
            for (int neighbor : graph.get(node)) {
                if (colors[neighbor] == -1) { // If the neighbor is uncolored, color it with opposite color
                    colors[neighbor] = 1 - colors[node]; // Alternate color (0 -> 1 or 1 -> 0)
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) { // If the neighbor has the same color, return false
                    return false;
                }
            }
        }

        return true; // All nodes in the component can be properly colored
    }

    
}
