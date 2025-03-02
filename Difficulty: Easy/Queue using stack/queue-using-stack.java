//{ Driver Code Starts
import java.util.*;


class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queue g = new Queue();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.enqueue(a);
				}
				else if(QueryType == 2)
				System.out.print(g.dequeue()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends


class Queue
{
   


    Stack<Integer> s1 = new Stack<>(); // Input stack
    Stack<Integer> s2 = new Stack<>(); // Output stack

    /* Enqueue operation */
    void enqueue(int x) {
        s1.push(x); // Push directly to s1
    }

    /* Dequeue operation */
    int dequeue() {
        if (s2.isEmpty()) { 
            if (s1.isEmpty()) return -1; // Queue is empty

            // Transfer elements from s1 to s2 (reversing order)
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop(); // Pop from s2 (FIFO order)
    }
}


