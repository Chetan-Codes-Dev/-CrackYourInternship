import java.util.*;

class Main {
    // create two empty hash sets that store all
    // BST elements and leaf nodes respectively.
    static HashSet<Integer> all_nodes
        = new HashSet<Integer>();
    static HashSet<Integer> leaf_nodes
        = new HashSet<Integer>();

    /* A utility function to insert a new Node
    with given key in BST */
    public static Node insert(Node node, int key)
    {
        /* If the tree is empty, return a new Node */
        if (node == null)
            return new Node(key);

        /* Otherwise, recur down the tree */
        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);

        /* return the Node */
        return node;
    }
    // Function to store all node of given binary search
    // tree
    public static void storeNodes(Node root)
    {
        if (root == null)
            return;

        // store all node of binary search tree
        all_nodes.add(root.data);

        // store leaf node in leaf_hash
        if (root.left == null && root.right == null) {
            leaf_nodes.add(root.data);
            return;
        }

        // recur call rest tree
        storeNodes(root.left);
        storeNodes(root.right);
    }

    // Returns true if there is a dead end in tree,
    // else false.
    public static boolean isDeadEnd(Node root)
    {
        // Base case
        if (root == null)
            return false;

        // insert 0 in 'all_nodes' for handle case
        // if bst contain value 1
        all_nodes.add(0);

        // Call storeNodes function to store all BST Node
        storeNodes(root);

        // Traversal leaf node and check Tree contain
        // continuous sequence of
        // size tree or Not
        for (int i : leaf_nodes) {
            int x = i;

            // Here we check first and last element of
            // continuous sequence that are x-1 & x+1
            if (all_nodes.contains(x + 1)
                && all_nodes.contains(x - 1)) {
                return true;
            }
        }
        return false;
    }

    // Driver program
    public static void main(String[] args)
    {
        /*       8
               /   \
              5    11
             /  \
            2    7
             \
              3
               \
                4 */
        Node root = null;
        root = insert(root, 8);
        root = insert(root, 5);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 7);
        root = insert(root, 11);
        root = insert(root, 4);
        if (isDeadEnd(root) == true)
            System.out.println("Yes");

        else
            System.out.println("No");
    }
}

// A BST node
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}