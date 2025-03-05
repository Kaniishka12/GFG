//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int orangesRotting(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0, time = 0;

        // Step 1: Add all initially rotten oranges to queue & count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // Rotten orange
                } else if (mat[i][j] == 1) {
                    freshOranges++; // Count fresh oranges
                }
            }
        }

        // If no fresh oranges, return 0 (no time needed)
        if (freshOranges == 0) return 0;

        // Step 2: BFS to rot oranges in minimum time
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false; // Track if any new orange rotted this round

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0], ny = y + dir[1];

                    // Check if the neighboring cell is a fresh orange
                    if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && mat[nx][ny] == 1) {
                        mat[nx][ny] = 2; // Rot the orange
                        queue.offer(new int[]{nx, ny});
                        freshOranges--; // Reduce fresh orange count
                        rotted = true;
                    }
                }
            }
            if (rotted) time++; // Increase time if any orange rotted
        }

        // Step 3: If fresh oranges still remain, return -1
        return (freshOranges == 0) ? time : -1;
    }
}