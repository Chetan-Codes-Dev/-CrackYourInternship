class Solution {
    public TreeNode f(int[] pre, int[] post, int preS, int preE, int postS, int postE){
      if(postS>postE) return null;
      int rootVal=pre[preS];
      TreeNode root=new TreeNode(rootVal);
      if(preS==preE) return root;
      int p=postS;
      for(int i=postS; i<=postE-1; i++){
        if(pre[preS+1]==post[i]) {
          p=i;
          break;
        }
      }

      int lPostS=postS;
      int lPostE=p;
      int rPostS=p+1;
      int rPostE=postE-1;
      int lPreS=preS+1;
      int lPreE=lPostE-lPostS+preS+1;
      int rPreS=lPreE+1;
      int rPreE=preE;
      root.left=f(pre, post, lPreS, lPreE, lPostS, lPostE);
      root.right=f(pre, post, rPreS, rPreE, rPostS, rPostE);
      return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
      return f(preorder, postorder, 0, preorder.length-1, 0, preorder.length-1);
    }
}