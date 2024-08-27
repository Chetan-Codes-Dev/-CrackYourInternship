public class Codec {

    // Helper method for serialization: Encodes a tree into a string format
    public void serializeHelper(TreeNode root, StringBuilder output) {
        // If the node is null, append "*" to represent a null node in the serialized data
        if (root == null) {
            output.append("* ");
            return;
        }

        // Append the current node's value followed by a space for separation
        output.append(root.val).append(" ");
        
        // Recursively serialize the left subtree
        serializeHelper(root.left, output);
        
        // Recursively serialize the right subtree
        serializeHelper(root.right, output);
    }

    // Main method to start the serialization process
    public String serialize(TreeNode root) {
        StringBuilder output = new StringBuilder(); // Use StringBuilder to construct the serialized string
        
        // Start the serialization with the helper method
        serializeHelper(root, output);
        
        // Convert StringBuilder to a string and return it
        return output.toString();
    }

    // Helper method for deserialization: Decodes the string back into a tree
    public TreeNode deserializeHelper(String[] data, int[] index) {
        // Base case: If we have processed all the data, return null
        if (index[0] >= data.length) return null;

        // Get the current value in the data array
        String currVal = data[index[0]];
        index[0]++; // Increment the index to move to the next element

        // If the current value is "*", it represents a null node, so return null
        if (currVal.equals("*")) {
            return null;
        }

        // Create a new TreeNode with the current value
        TreeNode root = new TreeNode(Integer.parseInt(currVal));
        
        // Recursively build the left subtree using the next part of the data
        root.left = deserializeHelper(data, index);
        
        // Recursively build the right subtree using the remaining part of the data
        root.right = deserializeHelper(data, index);

        // Return the current root node after constructing the entire tree/subtree
        return root;
    }

    // Main method to start the deserialization process
    public TreeNode deserialize(String data) {
        // Split the input data string by spaces to get each node's value
        String[] nodeValues = data.split(" ");
        
        // Create an array to track the current index (used in the helper method)
        int[] index = new int[1];
        
        // Start the deserialization with the helper method
        return deserializeHelper(nodeValues, index);
    }
}