class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if (k > q.size() || k <= 0) return q;
        Stack<Integer> s=new Stack<>();
        int n=q.size();
        for(int i=0;i<k;i++){
            s.push(q.poll());
        }
        while(!s.isEmpty()){
            q.offer(s.pop());
        }
        for(int i=0;i<n-k;i++){
            q.offer(q.poll());
        }
        return q;
    }
}