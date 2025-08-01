class Solution {
    public int startStation(int[] gas, int[] cost) {
        // Your code here
        int pos=0;
        int sum=0;
        int tot=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            if(sum<0){
                tot+=sum;
                sum=0;
                pos=i+1;
            }
        }
        tot+=sum;
        if(tot>=0){
            return pos;
        }
        return -1;
        
    }
}