//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution{
public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
    int n = adj.size();
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();

    // Step 1: Fill the stack with nodes in finishing order
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i, adj, visited, stack);
        }
    }

    // Step 2: Reverse the graph
    ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        reversedGraph.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
        for (int neighbor : adj.get(i)) {
            reversedGraph.get(neighbor).add(i);
        }
    }

    // Step 3: Do DFS in the order of the stack on reversed graph
    Arrays.fill(visited, false);
    int sccCount = 0;
    while (!stack.isEmpty()) {
        int node = stack.pop();
        if (!visited[node]) {
            reverseDFS(node, reversedGraph, visited);
            sccCount++;
        }
    }

    return sccCount;
}

private static void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited, stack);
        }
    }
    stack.push(node);
}

private static void reverseDFS(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            reverseDFS(neighbor, graph, visited);
        }
    }
}
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            System.out.println(obj.kosaraju(adj));

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends