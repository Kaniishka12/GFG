// User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    public static Node reverseBetween(int a, int b, Node head) {
        // code here
        if(head==null|| a==b){
            return head;
        }
        Node dummy=new Node(0);
        dummy.next=head;
        Node prev=dummy;
        for(int i=1;i<a;i++){
            prev=prev.next;
        }
        Node curr=prev.next;
        Node nextt;
        for(int i=0;i<b-a;i++){
            nextt=curr.next;
            curr.next=nextt.next;
            nextt.next=prev.next;
            prev.next=nextt;
        }
        return dummy.next;
    }
}