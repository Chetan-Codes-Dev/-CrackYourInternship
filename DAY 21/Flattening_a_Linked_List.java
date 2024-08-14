// Java Program for flattening a linked list

import java.util.*;

class Node {
    int data;
    Node next, bottom;

    Node(int newData) {
        data = newData;
        next = bottom = null;
    }
}

public class GFG {

    // Function to flatten the linked list
    static Node flatten(Node root) {
        List<Integer> values = new ArrayList<>();

        // Push values of all nodes into a list
        while (root != null) {
            // Push the head node of the sub-linked-list
            values.add(root.data);

            // Push all the nodes of the sub-linked-list
            Node temp = root.bottom;
            while (temp != null) {
                values.add(temp.data);
                temp = temp.bottom;
            }

            // Move to the next head node
            root = root.next;
        }

        // Sort the node values in ascending order
        Collections.sort(values);

        // Construct the new flattened linked list
        Node tail = null;
        Node head = null;
        for (int value : values) {
            Node newNode = new Node(value);

            // If this is the first node of the linked list,
            // make the node as head
            if (head == null)
                head = newNode;
            else
                tail.bottom = newNode;
            tail = newNode;
        }

        return head;
    }

    // Function to print the linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
        // Create a hard-coded linked list:
        // 5 -> 10 -> 19 -> 28
        // |    |     |
        // V    V     V
        // 7    20    22
        // |          |
        // V          V
        // 8          50
        // |
        // V
        // 30

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);

        // Function call
        head = flatten(head);

        printList(head);
    }
}
