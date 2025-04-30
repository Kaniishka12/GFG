//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {

    public String findOrder(String[] words) {
        int K = 26; // Total lowercase English letters
        Set<Character> uniqueChars = new HashSet<>();
        List<int[]> edges = new ArrayList<>();

        // Collect all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
        }

        // Build graph edges by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean foundDiff = false;

            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    edges.add(new int[] { w1.charAt(j) - 'a', w2.charAt(j) - 'a' });
                    foundDiff = true;
                    break;
                }
            }

            // Invalid case: word1 is longer and is a prefix of word2
            if (!foundDiff && w1.length() > w2.length()) {
                return "";
            }
        }

        int[][] edgeArray = new int[edges.size()][2];
        for (int i = 0; i < edges.size(); i++) {
            edgeArray[i] = edges.get(i);
        }

        int[] order = topologicalSort(26, edgeArray);

        if (order.length == 0) return "";

        StringBuilder result = new StringBuilder();
        boolean[] used = new boolean[26];

        for (int ch : order) {
            if (uniqueChars.contains((char)(ch + 'a'))) {
                result.append((char) (ch + 'a'));
                used[ch] = true;
            }
        }

        // Check for unused characters to ensure full ordering
        for (char c : uniqueChars) {
            if (!used[c - 'a']) {
                result.append(c);
            }
        }

        return result.toString();
    }

    private int[] topologicalSort(int V, int[][] edges) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        boolean[] onPath = new boolean[V]; // for cycle detection

        List<Integer>[] adj = constructAdj(V, edges);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (hasCycle(i, adj, visited, onPath, stack)) {
                    return new int[0]; // return empty array if cycle found
                }
            }
        }

        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }

    private boolean hasCycle(int v, List<Integer>[] adj, boolean[] visited, boolean[] onPath, Stack<Integer> stack) {
        visited[v] = true;
        onPath[v] = true;

        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, adj, visited, onPath, stack)) return true;
            } else if (onPath[neighbor]) {
                return true; // cycle detected
            }
        }

        onPath[v] = false;
        stack.push(v);
        return false;
    }

    private List<Integer>[] constructAdj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
        }
        return adj;
    }
}

//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends