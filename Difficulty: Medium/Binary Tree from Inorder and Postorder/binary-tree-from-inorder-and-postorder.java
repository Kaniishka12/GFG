//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

public class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InorderPostorderToTree ip = new InorderPostorderToTree();

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int[] inorder = new int[n];
            for (int i = 0; i < n; i++) {
                inorder[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            int[] postorder = new int[n];
            for (int i = 0; i < n; i++) {
                postorder[i] = Integer.parseInt(a2[i]);
            }

            Solution g = new Solution();
            Node root = g.buildTree(inorder, postorder);
            ip.preOrder(root);
            System.out.println();
            System.out.println("~");

            t--; // Decrement the test case count
        }
    }
}

// } Driver Code Ends

class Solution {
    private static HashMap<Integer, Integer> inorderMap;
    private static int postIndex;

    Node buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postIndex = postorder.length - 1;

        // Store inorder values and their indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(postorder, 0, inorder.length - 1);
    }

    private Node constructTree(int[] postorder, int left, int right) {
        if (left > right) return null;

        // Get the root value from postorder
        int rootValue = postorder[postIndex--];
        Node root = new Node(rootValue);

        // Get the index of the root in inorder
        int inorderIndex = inorderMap.get(rootValue);

        // Build right subtree first
        root.right = constructTree(postorder, inorderIndex + 1, right);
        // Build left subtree
        root.left = constructTree(postorder, left, inorderIndex - 1);

        return root;
    }

    // Function to print Preorder traversal
    void printPreorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}