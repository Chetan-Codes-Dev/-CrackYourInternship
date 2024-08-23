class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root==null){
            return list;
        }
        while(true){
            int size = q.size();
            if(size==0){
                return list;
            }
            List<Integer> data = new ArrayList<>();
            while(size>0){
                TreeNode temp = q.poll();
                data.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                size--;
            }
            list.add(data);
        }
    }
}