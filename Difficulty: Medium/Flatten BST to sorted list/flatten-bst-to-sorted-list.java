//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class GFG
{
    public static void printList(Node head) {
        while (head != null) {
            if (head.left != null)
                System.out.print("-1 ");
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String str = sc.nextLine();
            Node root = buildTree(str);
            Solution ob = new Solution();
            Node ans = ob.flattenBST(root);
            printList(ans);
        
System.out.println("~");
}
        sc.close();
    }

    private static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String[] ip = str.split("\\s+");
        int index = 0;

        Node root = new Node(Integer.parseInt(ip[index++]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && index < ip.length) {
            Node currNode = queue.poll();

            String currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            if (index >= ip.length)
                break;
            currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
        }

        return root;
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // Helper function for inorder traversal to store values
    private void inorderTraversal(Node root, List<Integer> inorderVal) {
        if (root == null) return;

        inorderTraversal(root.left, inorderVal);
        inorderVal.add(root.data);
        inorderTraversal(root.right, inorderVal);
    }
    
    // Function to flatten the BST
    public Node flattenBST(Node root) {
        if (root == null) return null;

        List<Integer> inorderVal = new ArrayList<>();
        inorderTraversal(root, inorderVal); // Store inorder traversal values

        // Create new root
        Node newRoot = new Node(inorderVal.get(0));
        Node curr = newRoot;

        // Construct right-skewed tree
        for (int i = 1; i < inorderVal.size(); i++) {
            Node temp = new Node(inorderVal.get(i));
            curr.left = null;
            curr.right = temp;
            curr = temp;
        }

        return newRoot;
    }

    // Function to print the flattened tree
    public void printFlattenedBST(Node root) {
        while (root != null) {
            System.out.print(root.data + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }

    // Driver code
   
}
