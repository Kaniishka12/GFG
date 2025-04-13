//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for (int i=0; i< edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new int[]{v,w});
            
            if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<>());
            }
            adj.get(v).add(new int[]{u,w});
        }
        
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        
        set.add(new int[]{0,src});
        
        while(!set.isEmpty()){
            int[] top=set.pollFirst();
            int nodeDistance = top[0];
            int topNode = top[1];
            
            if(!adj.containsKey(topNode)) continue;
            
            ArrayList<int[]> neighbors = adj.get(topNode);
            for(int i = 0; i<neighbors.size();i++){
                int[] neighbor = neighbors.get(i);
                int nbrNode = neighbor[0];
                int weight = neighbor[1];
                
                if(nodeDistance + weight < dist[nbrNode]){
                    set.remove(new int[]{dist[nbrNode],nbrNode});
                    dist[nbrNode] = nodeDistance +weight;
                    set.add(new int[]{dist[nbrNode],nbrNode});
                }
            }
        }
        
        return dist;
        
    }
}