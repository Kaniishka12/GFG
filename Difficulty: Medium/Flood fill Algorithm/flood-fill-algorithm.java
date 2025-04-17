//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        // If the new color is the same as the original, no need to proceed
        if (originalColor == newColor) return image;

        // Start the flood fill
        fill(image, sr, sc, originalColor, newColor);
        return image;
    }

    private void fill(int[][] image, int r, int c, int originalColor, int newColor) {
        // Check bounds
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;

        // Check if current cell is not the original color
        if (image[r][c] != originalColor) return;

        // Change to new color
        image[r][c] = newColor;

        // Recurse in all four directions
        fill(image, r + 1, c, originalColor, newColor); // down
        fill(image, r - 1, c, originalColor, newColor); // up
        fill(image, r, c + 1, originalColor, newColor); // right
        fill(image, r, c - 1, originalColor, newColor); // left
    }
}