//{ Driver Code Starts
import java.util.*;


class StackUsingQueues
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queues g = new Queues();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.push(a);
				}
				else if(QueryType == 2)
				System.out.print(g.pop()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends




class Queues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Function to push an element into stack using two queues.
    void push(int a) {
        q1.add(a);  // Simply enqueue to q1
    }

    // Function to pop an element from stack using two queues.
    int pop() {
        if (q1.isEmpty()) return -1;  // Stack is empty

        // Transfer all elements except last to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        // The last element in q1 is the top of the stack
        int poppedElement = q1.poll();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedElement;
    }
}
