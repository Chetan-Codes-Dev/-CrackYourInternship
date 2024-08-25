class Solution {
    Queue<TreeNode> queue = new LinkedList<>(); //Global Declaration of Queue
    public void addToQueue(TreeNode root)
    {   //pre-order Traversal Of Queue
        if(root == null)
            return;
        //Storing the nodes in Queue according to pre-order
        queue.add(root);         
        addToQueue(root.left);
        addToQueue(root.right);
    }
    public void flatten(TreeNode root) {
        addToQueue(root); //call the addToQueue function
        //Arrange the nodes in the queue in form of a linkedList or Right-Skewed Tree
        while(!queue.isEmpty())
        {   
            TreeNode temp = queue.poll();
            temp.right = queue.peek();
            temp.left = null;
        }

        
    }
}