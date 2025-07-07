/*
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        Node ne=new Node(Integer.MIN_VALUE);
        Node n=ne;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                ne.next=head1;
                head1=head1.next;
            }else{
                ne.next=head2;
                head2=head2.next;
            }
            ne=ne.next;
        }
        if(head1==null){
            ne.next=head2;
        }else if(head2==null){
            ne.next=head1;
        }
        return n.next;
    }
}