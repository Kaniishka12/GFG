//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    private static HashMap<Integer, Integer> inorderMap;
    private static int preorderIndex;

    public static Node buildTree(int inorder[], int preorder[]) {
        inorderMap = new HashMap<>();
        preorderIndex = 0;

        // Store inorder values and their indices for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(preorder, 0, inorder.length - 1);
    }

    private static Node constructTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        // Get the root value from preorder and increment index
        int rootValue = preorder[preorderIndex++];
        Node root = new Node(rootValue);

        // Get the index of the root in inorder
        int inorderIndex = inorderMap.get(rootValue);

        // Recursively construct the left and right subtrees
        root.left = constructTree(preorder, left, inorderIndex - 1);
        root.right = constructTree(preorder, inorderIndex + 1, right);

        return root;
    }

    // Postorder Traversal Helper
    public static void postOrderTraversal(Node root, List<Integer> result) {
        if (root == null) return;
        postOrderTraversal(root.left, result);
        postOrderTraversal(root.right, result);
        result.add(root.data);
    }

    // Wrapper function to return postorder traversal
    public static List<Integer> postOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }
}