class Solution {
    private TreeNode small = null, big = null, prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = small.val;
        small.val = big.val;
        big.val = temp;
    }

    private void inorder(TreeNode r) {
        if (r == null) return;

        inorder(r.left);

        if (prev != null && prev.val > r.val) {
            small = r;
            if (big != null) return;
            big = prev;
        }

        prev = r;
        inorder(r.right);
    }
}