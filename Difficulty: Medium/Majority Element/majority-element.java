class Solution {
    int majorityElement(int arr[]) {
        // code here
        int count =0;
        int ele=0;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                ele=arr[i];
                count=1;
            }
            else if(arr[i]==ele){
                count++;
            }
            else{
                count--;
            }
        }
        int check=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                check++;
            }
        }
        if(check>(arr.length/2)){
            return ele;
        }
        return -1;
    }
}