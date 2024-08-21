class Solution {
    public boolean isBalanced(TreeNode root) {
       
        return maxHeight(root)!=-1;
    }
    public int maxHeight(TreeNode root){
        if(root==null)return 0;
        
        int lh=maxHeight(root.left);
        if(lh==-1)return -1;

         int rh=maxHeight(root.right);
        if(rh==-1)return -1;

        if(Math.abs(lh-rh)>1)return -1;
        else return 1+Math.max(lh,rh);

    }
}