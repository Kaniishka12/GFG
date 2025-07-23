class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int comp=target-arr[i];
            if(hm.containsKey(comp)){
                return true;
            }
            hm.put(arr[i],i);
        }
        return false;
    }
}