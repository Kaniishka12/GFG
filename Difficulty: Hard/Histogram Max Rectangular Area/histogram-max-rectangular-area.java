class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int n=arr.length;
        Stack <Integer> s=new Stack<>();
        int[] left=new int[n];
        int[] right=new int[n];
        //next smaller left
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                left[i]=-1;
            }else{
                left[i]=s.peek();
            }
            s.push(i);
        }
        s.clear();
        //next smaller right
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                right[i]=n;
            }else{
                right[i]=s.peek();
            }
            s.push(i);
        }
        int ma=0;
        for(int i=0;i<n;i++){
            int w=right[i]-left[i]-1;
            ma=Math.max(ma,w*arr[i]);
            
        }
        return ma;
    }
}
