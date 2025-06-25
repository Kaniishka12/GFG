

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        int m=mat.length;
        int n=mat[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid=(high+low)/2;
            int row=mid/n;
            int col=mid%n;
            if(mat[row][col]==x){
                return true;
            }
            else if(mat[row][col]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
        
    }
}
