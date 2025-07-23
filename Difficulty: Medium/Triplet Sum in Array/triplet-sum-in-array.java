class Solution {
    public static boolean hasTripletSum(int arr[], int target) {
        // code Here
        if(arr==null||arr.length<3){
            return false;
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int l=i+1;
            int r=arr.length-1;
            while(l<r){
            int s=arr[i]+arr[l]+arr[r];
            if(s==target){
                return true;
            }else if (s<target){
                l++;
            }else{
                r--;
            }
            }
        }
        return false;
    }
}
