//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        
        
        // Create a HashMap to group strings by their sorted form
        Map<String, ArrayList<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String s : arr) {
            // Convert the string to a character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            // Create a key by converting the sorted character array back to a string
            String key = new String(charArray);

            // If the key doesn't exist in the map, initialize a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the original string to the list corresponding to the key
            map.get(key).add(s);
        }

        // Convert the values of the map to an ArrayList<ArrayList<String>>
        return new ArrayList<>(map.values());
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends