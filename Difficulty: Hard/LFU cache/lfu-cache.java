//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LFUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LFUCache cache = new LFUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class LFUCache {
    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;  // Initial frequency is 1
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size > 0) {
                Node lastNode = tail.prev;
                remove(lastNode);
                return lastNode;
            }
            return null;
        }
    }

    private int capacity, minFreq;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, DoublyLinkedList> freqToDLL;

    public LFUCache(int cap) {
        capacity = cap;
        minFreq = 0;
        keyToNode = new HashMap<>();
        freqToDLL = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if (keyToNode.size() >= capacity) {
                removeLFU();
            }
            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            minFreq = 1;
            freqToDLL.putIfAbsent(1, new DoublyLinkedList());
            freqToDLL.get(1).addToHead(newNode);
        }
    }

    private void updateNode(Node node) {
        int oldFreq = node.freq;
        freqToDLL.get(oldFreq).remove(node);
        if (freqToDLL.get(oldFreq).size == 0 && oldFreq == minFreq) {
            minFreq++;
        }

        node.freq++;
        freqToDLL.putIfAbsent(node.freq, new DoublyLinkedList());
        freqToDLL.get(node.freq).addToHead(node);
    }

    private void removeLFU() {
        DoublyLinkedList minFreqList = freqToDLL.get(minFreq);
        Node removedNode = minFreqList.removeTail();
        keyToNode.remove(removedNode.key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */