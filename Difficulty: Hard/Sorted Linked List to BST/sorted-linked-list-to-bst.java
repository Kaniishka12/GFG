//{ Driver Code Starts
import java.io.*;
import java.util.*;

class LNode {
    int data;
    LNode next;

    LNode(int d) {
        data = d;
        next = null;
    }
}

class TNode {
    int data;
    TNode left, right;

    TNode(int x) {
        data = x;
        left = right = null;
    }
}

class ListToBST {

    /* Function to print linked list */
    public static void preOrder(TNode root) {

        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /* Driver program to test above functions */
    public static void main(String args[]) throws IOException {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            LNode head = new LNode(Integer.parseInt(str[0]));
            LNode tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new LNode(Integer.parseInt(str[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            TNode root = obj.sortedListToBST(head);
            preOrder(root);

            System.out.println();

            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d;
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }

}*/

class Solution {
    static class HeadRef {
        LNode head;
        HeadRef(LNode node) {
            this.head = node;
        }
    }

    public int countNodes(LNode head) {
        LNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public TNode sortedBST(HeadRef head, int n) {
        if (n <= 0 || head.head == null) {
            return null;
        }

        TNode left = sortedBST(head, n / 2);

        TNode root = new TNode(head.head.data);
        root.left = left;

        head.head = head.head.next;

        root.right = sortedBST(head, n - (n / 2) - 1);

        return root;
    }

    public TNode sortedListToBST(LNode head) {
        int n = countNodes(head);
        HeadRef headRef = new HeadRef(head);
        return sortedBST(headRef, n);
    }
}
