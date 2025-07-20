// User function Template for Java
class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        int p=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                p+=prices[i]-prices[i-1];
            }
        }
        return p;
        
    }
}