class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        return mergesort(arr,0,arr.length-1);
    }
    private static int mergesort(int[] arr,int low,int high){
        int count=0;
       
        if(low<high){
            int mid=(high+low)/2;
            count+=mergesort(arr,low,mid);
            count+=mergesort(arr,mid+1,high);
            count+=merge(arr,low,mid,high);
        }
        return count;
        
    }
    private static int merge(int[] arr,int low,int mid,int high){
        int ivc=0;
        int left=low;
        int right=mid+1;
        ArrayList<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left++]);
            }else{
                temp.add(arr[right++]);
                ivc+=mid-left+1;
            }
        }
        while(left<=mid){
               temp.add(arr[left++]);
        }
        while(right<=high){
            temp.add(arr[right++]);
        }
        for (int k = low; k <= high; k++) {
            arr[k] = temp.get(k - low);
        }
        return ivc;
    }
}