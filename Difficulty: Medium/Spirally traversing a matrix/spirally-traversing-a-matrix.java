//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
         ArrayList<Integer> a = new ArrayList<>();
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return a;
        }

        int sr = 0; // Start row
        int sc = 0; // Start column
        int er = mat.length - 1; // End row
        int ec = mat[0].length - 1; // End column

        while (sr <= er && sc <= ec) {
            for (int j = sc; j <= ec; j++) {
                a.add(mat[sr][j]);
            }
            for (int i = sr + 1; i <= er; i++) {
                a.add(mat[i][ec]);
            }
            for (int j = ec - 1; j >= sc; j--) {
                if (sr == er) {
                    break;
                }
                a.add(mat[er][j]);
            }
            for (int i = er - 1; i >= sr + 1; i--) {
                if (sc == ec) {
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
