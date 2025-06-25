// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> a=new ArrayList<>();
        int k=firstele(arr,x);
        a.add(k);
        int m=secele(arr,x);
        a.add(m);
        return a;
    }
    public int firstele(int arr[],int x){
        int low=0;
        int high=arr.length-1;
        int first=-1;
    
        while(low<=high){
            
            int mid=(low+high)/2;
            if(arr[mid]==x){
                first=mid;
                high=mid-1;
            }
            else if(arr[mid]<x){
               low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return first;
        
    }
    public int secele(int arr[],int x){
        int low=0;
        int high=arr.length-1;
        int second=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                second=mid;
                low=mid+1;
            }
            else if(arr[mid]<x){
             low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return second;
        
    }
}
