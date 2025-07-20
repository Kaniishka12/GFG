class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> ar=new ArrayList<>();
        HashSet<Integer> hs=new HashSet<>();
        int n=arr.length;
        int a=0;
        int b=0;
        for(int i=0;i<n;i++){
            if(hs.contains(arr[i])){
                a=arr[i];
            }
            hs.add(arr[i]);
        }
        ar.add(a);
        for(int i=1;i<=n;i++){
            if(!hs.contains(i)){
                b=i;
            }
        }
        ar.add(b);
        return ar;
        
    }
}
