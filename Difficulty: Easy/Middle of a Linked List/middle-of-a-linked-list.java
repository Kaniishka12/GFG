/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    int getMiddle(Node head) {
        // Your code here.
        Node temp=head;
        int c=0;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        int i=0;
        int idx=(int)(c/2);
        Node emp=head;
        while(i<idx){
            emp=emp.next;
            i++;
        }
        return emp.data;
    }
}