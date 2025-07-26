class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
         ArrayList<Integer> a=new ArrayList<>();
         int sr=0;
         int er=mat.length-1;
         int sc=0;
         int ec=mat[0].length-1;
         while(sr<=er && sc<=ec){
             for(int i=sc;i<=ec;i++){
                 a.add(mat[sr][i]);
             }
             for(int i=sr+1;i<=er;i++){
                 a.add(mat[i][ec]);
             }
             for(int i=ec-1;i>=sc;i--){
                 if(sr==er){
                     break;
                 }
                 a.add(mat[er][i]);
             }
             for(int i=er-1;i>sr;i--){
                 if(sc==ec){
                     break;
                 }
                 a.add(mat[i][sc]);
             }
             
             sr++;
             sc++;
             er--;
             ec--;
         }
         return a;
         
    }
}
