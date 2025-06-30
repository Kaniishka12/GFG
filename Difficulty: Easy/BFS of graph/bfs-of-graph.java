class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        boolean[] visited=new boolean[adj.size()];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int c=q.poll();
            result.add(c);
            for(int n:adj.get(c)){
                if(!visited[n]){
                    q.add(n);
                    visited[n]=true;
                }
            }
        }
        return result;
        
    }
}