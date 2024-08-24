class Solution {
    Map<Long, Integer> mp = new HashMap<>();

    int ans =0;

    public int pathSum(TreeNode root, int targetSum) {
        
        mp.put(0L, 1);

        dfs(root, targetSum, 0L);

        return ans;
    }

    private void dfs(TreeNode root, int targetSum, Long curr_sum) {
        if (root == null) {
            return;
        }

        Long new_sum = curr_sum + root.val;

        Long target = new_sum - targetSum;

        ans += mp.getOrDefault(target, 0);

        mp.put(new_sum, mp.getOrDefault(new_sum, 0)+1);

        dfs(root.left, targetSum, new_sum);
        dfs(root.right, targetSum, new_sum);

         mp.put(new_sum, mp.get(new_sum)-1);
    }
}